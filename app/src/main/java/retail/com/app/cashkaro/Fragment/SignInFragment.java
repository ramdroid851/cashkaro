package retail.com.app.cashkaro.Fragment;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retail.com.app.cashkaro.R;
import retail.com.app.cashkaro.Utils.LoginListener;

/**
 * Created by R Ramesh on 10/03/17.
 */

public class SignInFragment extends Fragment {

    @BindView(R.id.userNameEditTextView)
    EditText userNameEditText;

    @BindView(R.id.passwordEditTextView)
    EditText passwordEditText;

    @BindView(R.id.signUpTextView)
    TextView signUpTextView;

    private Unbinder unbinder;
    private LoginListener mLoginListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mLoginListener = (LoginListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_sign_in, null);
        unbinder = ButterKnife.bind(this, view);
        signUpTextView.setPaintFlags(signUpTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
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

    @OnClick(R.id.forgot_password)
    public void forgotPassword() {
        Toast.makeText(getActivity(), getString(R.string.yet_to_implement), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.signUpTextView)
    public void showSignUpScreen() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SignUpFragment()).commit();
    }

    @OnClick(R.id.signInButton)
    public void signIN() {
        if (validateInputs() && mLoginListener != null) {
            mLoginListener.onLogin();
        }
    }

    private boolean validateInputs() {
        String username = userNameEditText.getText().toString();
        if (username == null || username.isEmpty()) {
            userNameEditText.setError(getString(R.string.enter_username));
            return false;
        }
        String password = passwordEditText.getText().toString();
        if (password == null || password.isEmpty()) {
            passwordEditText.setError(getString(R.string.enter_password));
            return false;
        }
        return true;
    }

}
