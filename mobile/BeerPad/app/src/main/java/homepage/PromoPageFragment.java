package homepage;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import utils.AnimationGenericUtils;

/**
 * Created by luisalfonsobejaranosanchez on 5/27/17.
 */

public class PromoPageFragment extends Fragment {

    private ViewGroup mainInformationContainer;
    private ViewGroup secondaryInformationContainer;

    private Context context;
    private AnimationGenericUtils.animations mainAnimation;
    private AnimationGenericUtils.animations secondaryAnimation;
    private boolean isFirstFragment = false;
    public int layoutId;

    public static PromoPageFragment newInstance(Context context, int layoutId, @Nullable AnimationGenericUtils.animations mainAnimation, @Nullable AnimationGenericUtils.animations secondaryAnimation) {
        PromoPageFragment fragment = new PromoPageFragment();
        fragment.layoutId = layoutId;
        fragment.context = context;
        fragment.mainAnimation = mainAnimation;
        fragment.secondaryAnimation = secondaryAnimation;
        return fragment;
    }

    public static PromoPageFragment newInstance(Context context, int layoutId, @Nullable AnimationGenericUtils.animations mainAnimation, @Nullable AnimationGenericUtils.animations secondaryAnimation, boolean firstPromo) {
        PromoPageFragment fragment = newInstance(context, layoutId, mainAnimation, secondaryAnimation);
        fragment.isFirstFragment = firstPromo;
        return fragment;
    }



}
