package ru.madmax.testcase3.presentation.signIn

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ru.madmax.testcase3.R
import ru.madmax.testcase3.databinding.FragmentSignInBinding
import ru.madmax.testcase3.util.LoginUiEvent
import ru.madmax.testcase3.util.hideKeyboard
import ru.madmax.testcase3.util.showIf

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<SignInViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInToLoginButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_signInFragment_to_loginFragment)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.eventFlow.collectLatest { event ->
                when (event) {
                    LoginUiEvent.Login -> {
                        view.findNavController().navigate(R.id.fragment_home)
                    }
                    is LoginUiEvent.ShowDialog -> {
                        AlertDialog
                            .Builder(requireContext())
                            .setTitle(R.string.alert_title)
                            .setMessage(event.message)
                            .show()
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.uiState.collectLatest { state ->
                binding.apply {
                    signInFirstNameError.showIf { state.firstNameError }
                    signInLastNameError.showIf { state.lastNameError }
                    signInEmailError.showIf { state.emailError }
                }
            }
        }

        binding.apply {
            signInButton.setOnClickListener {
                requireActivity().hideKeyboard()
                viewModel.signIn()
            }
            signInFirstName.addTextChangedListener(afterTextChanged = { text ->
                viewModel.updateFirstName(text.toString())
            })
            signInLastName.addTextChangedListener(afterTextChanged = { text ->
                viewModel.updateLastName(text.toString())
            })
            signInEmail.addTextChangedListener(afterTextChanged = { text ->
                viewModel.updateEmail(text.toString())
            })
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}