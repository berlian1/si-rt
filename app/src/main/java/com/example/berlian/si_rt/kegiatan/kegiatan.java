package com.example.berlian.si_rt.kegiatan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.berlian.si_rt.R;
import com.example.berlian.si_rt.request;
import com.example.berlian.si_rt.tambahKegiatan;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link kegiatan.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link kegiatan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kegiatan extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String url = "http://10.0.2.2/Si-RT2/index.php/rest/";
    private OnFragmentInteractionListener mListener;
    TextView text;
    public kegiatan() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static kegiatan newInstance(String param1, String param2) {
        kegiatan fragment = new kegiatan();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_kegiatan, container, false);
        // Inflate the layout for this fragment
        getKegiatan(rootView);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // jika fab di klik
                Intent intent = new Intent(getActivity(), tambahKegiatan.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
    private void getKegiatan(final View rootView){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient Client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                client(Client).
                build();

        request client = retrofit.create(request.class);
        Call<List<resKegiatan>> call = client.kegiatan();

        call.enqueue(new Callback<List<resKegiatan>>() {
            @Override
            public void onResponse(Call<List<resKegiatan>> call, Response<List<resKegiatan>> response) {
                List<resKegiatan> responses = response.body();
                Log.e("data", String.valueOf(responses));
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recycleKegiatan);
                recyclerView.setLayoutManager(layoutManager);
                AdapterKegiatan adapter = new AdapterKegiatan(responses);
                recyclerView.setAdapter(adapter);
                Log.e("response =", responses.get(0).getTanggal());

            }

            @Override
            public void onFailure(Call<List<resKegiatan>> call, Throwable t) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
