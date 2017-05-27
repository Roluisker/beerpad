package utils;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

import com.beerpad.R;

/**
 * Created by luisalfonsobejaranosanchez on 5/27/17.
 */

public class AnimationGenericUtils {

    public static enum animations {
        FADE_IN,
        FADE_OUT,
        SLIDE_IN_LEFT
    }

    public static void fadeInAnimation(final View view, Animation.AnimationListener listener , Context context) {

        Animation fadeInAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in);

        if(listener == null) {

            fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation arg0) {
                    if (!view.isShown())
                        view.setVisibility(View.VISIBLE);

                }

                @Override
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override
                public void onAnimationEnd(Animation arg0) {

                }
            });
        }else{
            fadeInAnimation.setAnimationListener(listener);
        }

        view.startAnimation(fadeInAnimation);

    }

    public static void fadeOutAnimation(final View view, Animation.AnimationListener listener, Context context) {

        Animation fadeOutAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_out);
        if (listener != null) {
            fadeOutAnimation.setAnimationListener(listener);
        } else {

            fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation arg0) {
                }

                @Override
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override
                public void onAnimationEnd(Animation arg0) {
                    if (view.isShown())
                        view.setVisibility(View.INVISIBLE);

                }
            });
        }

        view.startAnimation(fadeOutAnimation);

    }


    public static void fadeOutAnimationLogIn(final View view, Animation.AnimationListener listener, Context context) {

        Animation fadeOutAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_out_log_in);
        if (listener != null) {
            fadeOutAnimation.setAnimationListener(listener);
        } else {

            fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation arg0) {
                }

                @Override
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override
                public void onAnimationEnd(Animation arg0) {
                    if (view.isShown())
                        view.setVisibility(View.INVISIBLE);

                }
            });
        }

        view.startAnimation(fadeOutAnimation);

    }

    public static void slideRightToLeft(final View view, int delay, Context context) {

        Animation slideRightToLeftAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_right_to_left);
        slideRightToLeftAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
                if (!view.isShown())
                    view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

            }
        });

        slideRightToLeftAnimation.setStartOffset(delay);
        view.startAnimation(slideRightToLeftAnimation);

    }

    public static void zoom(final View expandedImageView, Animator.AnimatorListener listener, float zoom) {

        ViewPropertyAnimator animator = expandedImageView.animate();

        if (listener != null) {
            animator.setListener(listener);
        }

        animator.scaleY(zoom);
        animator.scaleX(zoom);
        animator.setDuration(400);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

    }



}
