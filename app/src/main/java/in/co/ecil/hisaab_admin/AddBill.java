package in.co.ecil.hisaab_admin;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Rishav
 * on 18/7/17.
 */

public class AddBill extends AppCompatActivity implements View.OnClickListener
{

    private Roommate payer;
    private EditText amountEditText,itemEditText;
    private Button payedByButton,splitAmongButton;
    private boolean[] splitAmongFlags;

    Dialog nameTileDialog;
    HisaabController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bill);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        itemEditText = (EditText) findViewById(R.id.itemEditText);
        payedByButton = (Button)findViewById(R.id.paidByButton);
        splitAmongButton = (Button)findViewById(R.id.splitAmongButton);
        controller = HisaabController.getInstance();
        payedByButton.setOnClickListener(this);
        splitAmongButton.setOnClickListener(this);

        payer = controller.getCurrentRoommate();

        payedByButton.setText(payer.getName());

        splitAmongFlags = new boolean[HisaabController.MAX_ROOMMATE_COUNT];

        for (int i=0;i<HisaabController.MAX_ROOMMATE_COUNT;i++)
            splitAmongFlags[i] = false;
    }

    public Dialog getNameTileDialog()
    {
        LinearLayout nameTiles[] = new LinearLayout[HisaabController.MAX_ROOMMATE_COUNT];
        TextView[] nameTextViews = new TextView[HisaabController.MAX_ROOMMATE_COUNT];

        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Drawable d = new ColorDrawable(ContextCompat.getColor(this, R.color.dialogBackground));
        d.setAlpha(200);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(d);

        nameTiles[controller.getRoommateIndexAt(IndexOf.Naveen)] = (LinearLayout) dialog.findViewById(R.id.naveen);
        nameTiles[controller.getRoommateIndexAt(IndexOf.Sandeep)] = (LinearLayout)dialog.findViewById(R.id.sandeep);
        nameTiles[controller.getRoommateIndexAt(IndexOf.Saurabh)] = (LinearLayout)dialog.findViewById(R.id.saurabh);
        nameTiles[controller.getRoommateIndexAt(IndexOf.Rishav)] = (LinearLayout) dialog.findViewById(R.id.rishav);

        nameTextViews[0]=(TextView) dialog.findViewById(R.id.naveenTextView);
        nameTextViews[1]=(TextView) dialog.findViewById(R.id.sandeepTextView);
        nameTextViews[2]=(TextView) dialog.findViewById(R.id.saurabhTextView);
        nameTextViews[3]=(TextView) dialog.findViewById(R.id.rishavTextView);

        for (int i=0;i<HisaabController.MAX_ROOMMATE_COUNT;i++)
        {
            nameTextViews[i].setText(HisaabController.getInstance().getRoommates()[i].getName());
            nameTiles[i].setOnClickListener(this);
        }

        return dialog;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.splitAmongButton:
                try
                {
                    if (nameTileDialog == null) nameTileDialog = getNameTileDialog();
                    nameTileDialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
                    nameTileDialog.show();
                }
                catch (NullPointerException ex)
                {
                    ex.printStackTrace();
                }
                break;

            case R.id.naveen:
                view.getBackground().setAlpha(64);
                break;
            case R.id.sandeep:
                view.getBackground().setAlpha(64);
                break;
            case R.id.saurabh:
                view.getBackground().setAlpha(64);
                break;
            case R.id.rishav:
                view.getBackground().setAlpha(64);
                break;
        }
    }
}
