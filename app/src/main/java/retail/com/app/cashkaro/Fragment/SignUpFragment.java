package retail.com.app.cashkaro.Fragment;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retail.com.app.cashkaro.R;
import retail.com.app.cashkaro.Utils.LoginListener;

public class SignUpFragment extends Fragment {

    private Unbinder unbinder;
    private LoginListener mLoginListener;

    @BindView(R.id.fullNameEditTextView)
    EditText userNameEditText;

    @BindView(R.id.emailEditTextView)
    EditText emailIdEditText;

    @BindView(R.id.passwordEditTextView)
    EditText passwordEditText;

    @BindView(R.id.termsAndCondtionsCheckBox)
    CheckBox termsAndConditionsCheckbox;

    @BindView(R.id.signInTextView)
    TextView signInTextView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mLoginListener = (LoginListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        unbinder = ButterKnife.bind(this, view);
        signInTextView.setPaintFlags(signInTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        return view;

    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        mLoginListener = null;
        super.onDetach();
    }

    @OnClick(R.id.signInTextView)
    public void showLoginScreen() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SignInFragment()).commit();
    }

    @OnClick(R.id.signUpButton)
    public void signUp() {
        if (validateInputs() && mLoginListener != null) {
            mLoginListener.onSignUp();
        }
    }

    private boolean validateInputs() {
        String username = userNameEditText.getText().toString();
        if (username == null || username.isEmpty()) {
            userNameEditText.setError(getString(R.string.enter_username));
            return false;
        }
        String email = emailIdEditText.getText().toString();
        if (email == null || email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailIdEditText.setError(getString(R.string.eneter_email_id));
            return false;
        }
        String password = passwordEditText.getText().toString();
        if (password == null || password.isEmpty()) {
            passwordEditText.setError(getString(R.string.enter_password));
            return false;
        }

        if (!termsAndConditionsCheckbox.isChecked()) {
            termsAndConditionsCheckbox.setError(getString(R.string.agree_to_terms_and_cond));
            return false;
        }
        return true;
    }
}
