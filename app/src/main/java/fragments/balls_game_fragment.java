package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack4goodcr.reactiontime.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link balls_game_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link balls_game_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class balls_game_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;

    private TextView txt_remaining_balls;
    private TextView txt_remaining_rounds;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;

    private Button btn_start;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public balls_game_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment balls_game_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static balls_game_fragment newInstance(String param1, String param2) {
        balls_game_fragment fragment = new balls_game_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(view == null) {
            view = inflater.inflate(
                    R.layout.fragment_balls_game, container, false);

            txt_remaining_balls = (TextView) view.findViewById(R.id.txt_remaining_balls);
            txt_remaining_rounds = (TextView) view.findViewById(R.id.txt_remaining_rounds);

            image1 = (ImageView) view.findViewById(R.id.imageView1);
            image2 = (ImageView) view.findViewById(R.id.imageView2);
            image3 = (ImageView) view.findViewById(R.id.imageView3);
            image4 = (ImageView) view.findViewById(R.id.imageView4);
            image5 = (ImageView) view.findViewById(R.id.imageView5);
            image6 = (ImageView) view.findViewById(R.id.imageView6);
            image7 = (ImageView) view.findViewById(R.id.imageView7);
            image8 = (ImageView) view.findViewById(R.id.imageView8);
            image9 = (ImageView) view.findViewById(R.id.imageView9);


            btn_start = (Button) view.findViewById(R.id.btn_start);
            Bundle bundle = this.getArguments();
            int[] rounds_balls = bundle.getIntArray("rounds_balls");
            txt_remaining_balls.setText(txt_remaining_balls.getText() + String.valueOf(rounds_balls[1]));
            txt_remaining_rounds.setText(txt_remaining_rounds.getText() + String.valueOf(rounds_balls[0]));

            btn_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    disableButtons();


                }
            });

        }

        // Inflate the layout for this fragment
        return view;
    }

    private void disableButtons() {
        image1.setClickable(false);
        image2.setClickable(false);
        image3.setClickable(false);
        image4.setClickable(false);
        image5.setClickable(false);
        image6.setClickable(false);
        image7.setClickable(false);
        image8.setClickable(false);
        image9.setClickable(false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
