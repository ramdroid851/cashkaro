package retail.com.app.cashkaro;

import android.content.Intent;
import android.os.Bundle;
import android.support.transition.Scene;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import retail.com.app.cashkaro.Fragment.SignInFragment;
import retail.com.app.cashkaro.Utils.LoginListener;

public class SigninSignupActivity extends AppCompatActivity implements LoginListener {
    private Scene mSceneLogging;
    private FrameLayout mFrtContent;

    private int mDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_signup);
        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.container, new SignInFragment()).commit();

//        mFrtContent = (FrameLayout) findViewById(R.imageId.container);
//
//        mDuration = LoginLoadingView.DURATION;
//
//        mSceneLogging = Scene.getSceneForLayout(mFrtContent, R.layout.logging_scene, this);
//        mSceneLogging.setEnterAction(new Runnable() {
//            @Override
//            public void run() {
//                final LoginLoadingView loginView = (LoginLoadingView) mFrtContent.findViewById(R.imageId.login_view);
//                loginView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        loginView.setStatus(LoginLoadingView.STATUS_LOGGING);
//                    }
//                }, mDuration);
//                loginView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        loginView.setStatus(LoginLoadingView.STATUS_LOGIN_SUCCESS);
//                    }
//                }, 4000);
//
//                loginView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent = new Intent(SigninSignupActivity.this, HomeScreenActivity.class);
//                        startActivity(intent);
//                    }
//                }, 6000);
//            }
//        });

    }

    private void loadLoggingScene() {
        Intent intent = new Intent(SigninSignupActivity.this, HomeScreenActivity.class);
        startActivity(intent);
        finish();
//        View view = null;
//        float finalRadius = (float) Math.hypot(mFrtContent.getWidth(), mFrtContent.getHeight());
//
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//        int x = location[0];
//        int y = location[1];
//
//        Animator anim = ViewAnimationUtils.createCircularReveal(mFrtContent, x + mTvSighUpWidth / 2, y - mTvSighUpHeight / 2, 100, finalRadius);
//        mFrtContent.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
//        anim.setDuration(mDuration);
//        anim.setInterpolator(new AccelerateDecelerateInterpolator());
//        anim.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mFrtContent.setBackgroundColor(Color.TRANSPARENT);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//        anim.start();
//
//        TransitionManager.go(mSceneLogging, new ChangeBounds().setDuration(mDuration).setInterpolator(new DecelerateInterpolator()));
    }

    @Override
    public void onLogin() {
        loadLoggingScene();
    }

    @Override
    public void onSignUp() {
        loadLoggingScene();
    }

}
