package razerdp.demo.popup;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;

import butterknife.BindView;
import razerdp.basepopup.BasePopupWindow;
import razerdp.basepopup.R;
import razerdp.demo.model.common.CommonInputInfo;
import razerdp.demo.utils.ButterKnifeUtil;
import razerdp.demo.utils.UIHelper;
import razerdp.demo.widget.DPTextView;

/**
 * Created by 大灯泡 on 2019/9/22.
 *
 * @see CommonInputInfo
 */
public class PopupInput extends BasePopupWindow {
    @BindView(R.id.tv_send)
    DPTextView mTvSend;
    @BindView(R.id.ed_input)
    EditText mEdInput;

    public PopupInput(Context context) {
        super(context);
        ButterKnifeUtil.bind(this, getContentView());
        mTvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.toast(mEdInput.getText().toString());
                dismiss();
            }
        });
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_input);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return getTranslateVerticalAnimation(1f, 0f, 450);
    }


    @Override
    protected Animation onCreateDismissAnimation() {
        return getTranslateVerticalAnimation(0f, 1f, 450);
    }
}
