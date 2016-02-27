package fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack4goodcr.reactiontime.R;
import com.hack4goodcr.reactiontime.activities.game_scoring;
import java.util.ArrayList;
import java.util.Random;

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

    private ArrayList tiempo=new ArrayList();
    private ArrayList fintiempo=new ArrayList();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int rounds;
    private int balls;
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
            final int[] rounds_balls = bundle.getIntArray("rounds_balls");
            rounds = rounds_balls[0];
            balls = rounds_balls[1];
            txt_remaining_balls.setText(txt_remaining_balls.getText() + String.valueOf(rounds_balls[1]));
            txt_remaining_rounds.setText(txt_remaining_rounds.getText() + String.valueOf(rounds_balls[0]));

            btn_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inicialice();
                }

            });

            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image1.setImageResource(R.mipmap.brain_icon_off);
                    image1.setEnabled(false);
                    image1.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });

            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image2.setImageResource(R.mipmap.brain_icon_off);
                    image2.setEnabled(false);
                    image2.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });

            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image3.setImageResource(R.mipmap.brain_icon_off);
                    image3.setEnabled(false);
                    image3.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });

            image4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image4.setImageResource(R.mipmap.brain_icon_off);
                    image4.setEnabled(false);
                    image4.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });
            image5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image5.setImageResource(R.mipmap.brain_icon_off);
                    image5.setEnabled(false);
                    image5.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });
            image6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image6.setImageResource(R.mipmap.brain_icon_off);
                    image6.setEnabled(false);
                    image6.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });

            image7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image7.setImageResource(R.mipmap.brain_icon_off);
                    image7.setEnabled(false);
                    image7.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });
            image8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image8.setImageResource(R.mipmap.brain_icon_off);
                    image8.setEnabled(false);
                    image8.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }

                }
            });



            image9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tic=Integer.parseInt(txt_remaining_balls.getText().toString());
                    tic--;
                    txt_remaining_balls.setText(Integer.toString(tic));
                    image9.setImageResource(R.mipmap.brain_icon_off);
                    image9.setEnabled(false);
                    image9.clearFocus();
                    boolean fin= false;
                    try {
                        fin = rondafinish(tic);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(fin) {
                        balls = rounds_balls[1];
                        gameStart();
                    }
                }
            });

        }


        // Inflate the layout for this fragment
        return view;
    }

    public boolean rondafinish(int tic) throws InterruptedException {
        boolean fin=false;
        if(tic==0) {
            Time t = new Time();
            t.setToNow();
            fintiempo.add(t.toMillis(false));
            fin = true;
        }
        return fin;
    }

    public void inicialice(){
        txt_remaining_rounds.setText("0");
        txt_remaining_balls.setText(String.valueOf(balls));
        disableButtons();
        gameStart();
    }


    private void disableButtons() {
        image1.setEnabled(false);
        image2.setEnabled(false);
        image3.setEnabled(false);
        image4.setEnabled(false);
        image5.setEnabled(false);
        image6.setEnabled(false);
        image7.setEnabled(false);
        image8.setEnabled(false);
        image9.setEnabled(false);
    }

    public void gameStart(){
        btn_start.setEnabled(false);
        int ronda=Integer.parseInt(txt_remaining_rounds.getText().toString());

        if(ronda!=rounds) {
            ronda++;
            txt_remaining_rounds.setText(Integer.toString(ronda));

            rondaStart();

        }
        else {
            btn_start.setEnabled(true);
            tratarDatos();

        }
    }

    public void tratarDatos(){
        int iterator=tiempo.size();
        long aux=0;
        for(int i=0;i<iterator;i++){
            if((Long)fintiempo.get(i)>=(Long)tiempo.get(i))
                aux+=((Long) fintiempo.get(i)).longValue()-((Long) tiempo.get(i)).longValue();
            else
                aux+=((Long) tiempo.get(i)).longValue()-((Long) fintiempo.get(i)).longValue();
        }

        aux=aux/iterator;
        tiempo.clear();
        fintiempo.clear();
        if(iterator==0)
            aux=0;

        Intent intent = new Intent(getActivity(),game_scoring.class );
        Log.d("LOG","hello tiempooo " + aux);
        intent.putExtra("score",Long.toString(aux));
        startActivity(intent);
        this.onDetach();
    }

    public void rondaStart(){

        txt_remaining_balls.setText(String.valueOf(balls));

        selectButtons();
        Time t = new Time();
        t.setToNow();
        tiempo.add(t.toMillis(false));


    }

    public void selectButtons(){
        for(int i=0;i<balls;i++)
            secuencia();
    }

    public void secuencia(){

        boolean seguir=true;

        while(seguir) {
            Time t = new Time();

            t.setToNow();
            Random ran = new Random(t.toMillis(false));
            int n= ran.nextInt(9);
            Log.d("LOG","hello secuencia " + n);
            switch (n) {
                case 0:
                    if(!image1.isEnabled()){
                        image1.setImageResource(R.mipmap.brain_icon_on);
                        image1.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 1:
                    if(!image2.isEnabled()){
                        image2.setImageResource(R.mipmap.brain_icon_on);
                        image2.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 2:
                    if(!image3.isEnabled()){
                        image3.setImageResource(R.mipmap.brain_icon_on);
                        image3.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 3:
                    if(!image4.isEnabled()){
                        image4.setImageResource(R.mipmap.brain_icon_on);
                        image4.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 4:
                    if(!image5.isEnabled()){
                        image5.setImageResource(R.mipmap.brain_icon_on);
                        image5.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 5:
                    if(!image6.isEnabled()){
                        image6.setImageResource(R.mipmap.brain_icon_on);
                        image6.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 6:
                    if(!image7.isEnabled()){
                        image7.setImageResource(R.mipmap.brain_icon_on);
                        image7.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 7:
                    if(!image8.isEnabled()){
                        image8.setImageResource(R.mipmap.brain_icon_on);
                        image8.setEnabled(true);
                        seguir=false;
                    }
                    break;
                case 8:
                    if(!image9.isEnabled()){
                        image9.setImageResource(R.mipmap.brain_icon_on);
                        image9.setEnabled(true);
                        seguir=false;
                    }
                    break;
            }
        }
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
