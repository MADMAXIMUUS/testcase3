package ru.madmax.testcase3.presentation.login

import android.app.AlertDialog
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ru.madmax.testcase3.R
import ru.madmax.testcase3.databinding.FragmentLoginBinding
import ru.madmax.testcase3.util.LoginUiEvent
import ru.madmax.testcase3.util.hideKeyboard
import ru.madmax.testcase3.util.showIf

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.eventFlow.collectLatest { event ->
                when (event) {
                    LoginUiEvent.Login -> {
                        view.findNavController().navigate(R.id.action_global_mainFragment)
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
                    loginPasswordError.showIf { state.passwordError }
                    loginFirstNameError.showIf { state.firstNameError }
                    if (!state.passwordVisible) {
                        loginPassword.transformationMethod =
                            PasswordTransformationMethod.getInstance()
                    } else {
                        loginPassword.transformationMethod =
                            HideReturnsTransformationMethod.getInstance()
                    }
                }
            }
        }

        binding.apply {
            loginPasswordVisibilityButton.setOnClickListener {
                viewModel.updatePasswordVisibility()
            }
            loginButton.setOnClickListener {
                requireActivity().hideKeyboard()
                viewModel.login()
            }
            loginFirstName.addTextChangedListener(afterTextChanged = { text ->
                viewModel.updateFirstName(text.toString())
            })
            loginPassword.addTextChangedListener(afterTextChanged = { text ->
                viewModel.updatePassword(text.toString())
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}