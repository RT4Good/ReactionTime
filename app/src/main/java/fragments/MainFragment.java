package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hack4goodcr.reactiontime.R;
import com.hack4goodcr.reactiontime.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Spinner roundSpinner;
    private Spinner ballSpinner;
    private int rounds = 1;
    private int balls = 1;
    private View view;
    private OnDataPass dataPasser;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
                R.layout.fragment_main, container, false);

        roundSpinner = (Spinner) view.findViewById(R.id.spinnerRounds);
        ballSpinner = (Spinner) view.findViewById(R.id.spinnerBalls);
        // Create an ArrayAdapter using the string array and a default spinner layout
        List<Integer> roundList = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            roundList.add(i);
        }
        List<Integer> ballList = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            ballList.add(i);
        }

        passData(rounds, balls);

        ArrayAdapter<Integer> roundsAdapter = new ArrayAdapter<Integer>(view.getContext(), android.R.layout.simple_spinner_item, roundList);


        ArrayAdapter<Integer> ballsAdapter = new ArrayAdapter<Integer>(view.getContext(), android.R.layout.simple_spinner_item, ballList);

        roundsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ballsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        roundSpinner.setAdapter(roundsAdapter);
        ballSpinner.setAdapter(ballsAdapter);

        roundSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rounds = position + 1;
                passData(rounds, balls);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ballSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                balls = position + 1;
                passData(rounds, balls);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment
    }
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    /*    if (context instanceof OnFragmentInteractionListener) {
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

    public void passData(int rounds, int balls) {
        dataPasser.onDataPass(rounds, balls);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public interface OnDataPass {
        void onDataPass(int rounds, int balls);
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
