package io.google.gp_11;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdminUsersFragment extends Fragment {

    private Integer[] IMAGE = {R.drawable.person1, R.drawable.person4, R.drawable.person5};
    private String[] Name = {"Ahmed Abuelhassan", "Saad Khalifa", "Mohamed Atef"};
    private String[] country = {"USA", "SPAIN", "ITALY"};

    private ArrayList<model_user> userModels;
    private RecyclerView recyclerView;
    private fragment_user_adapter UserAdapter;

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPageNo;

    public AdminUsersFragment() {
        // Required empty public constructor
    }

    public static AdminUsersFragment newInstance(int pageNo) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        AdminUsersFragment fragment = new AdminUsersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        userModels = new ArrayList<>();
        for (int i = 0; i < Name.length; i++) {
            model_user UserModelForRecyclerView = new model_user(IMAGE[i], Name[i], country[i]);
            userModels.add(UserModelForRecyclerView);
        }
        super.onCreate(savedInstanceState);
        mPageNo = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users_admin, container, false);
        TextView myTextView_bold = (TextView) view.findViewById(R.id.toolbarText);
        myTextView_bold.setText("Users");
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setImageResource(R.drawable.adduser);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(getActivity(), AdminAddUserActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;

    }
    private void updateUI() {
        UserAdapter = new fragment_user_adapter(userModels);
        recyclerView.setAdapter(UserAdapter);
    }


    private class UsersHolder extends RecyclerView.ViewHolder {
        de.hdodenhof.circleimageview.CircleImageView userimage;
        TextView username;
        TextView usercounrty;
        public UsersHolder(View view) {
            super(view);
            userimage = (de.hdodenhof.circleimageview.CircleImageView) view.findViewById(R.id.personimage);
            username = (TextView) view.findViewById(R.id.username);
            usercounrty = (TextView) view.findViewById(R.id.usercountry);

        }
    }

    private class fragment_user_adapter extends RecyclerView.Adapter<UsersHolder> {
        private ArrayList<model_user> models;
        public fragment_user_adapter(ArrayList<model_user> Models) {
            models = Models;
        }
        @Override
        public UsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.recycler_view_users, parent, false);
            return new UsersHolder(view);
        }
        @Override
        public void onBindViewHolder(UsersHolder holder, int position) {
            final model_user modela = models.get(position);
            holder.userimage.setImageResource(modela.getImage());
            holder.username.setText(modela.getName());
            holder.usercounrty.setText(modela.getCountry());

        }
        @Override
        public int getItemCount() {
            return models.size();
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
