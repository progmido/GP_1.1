package AdminFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import AdminModels.model_user;
import io.google.gp_11.AdminUpdateUser;
import io.google.gp_11.R;

public class AdminUsersFragment extends Fragment {

    private Integer[] IMAGE = {R.drawable.person1, R.drawable.person4, R.drawable.person5};
    private String[] Name = {"Ahmed Abuelhassan", "Saad Khalifa", "Mohamed Atef"};
    private String[] country = {"USA", "SPAIN", "ITALY"};

    private ArrayList<model_user> userModels;
    private RecyclerView recyclerView;
    private fragment_user_adapter UserAdapter;


    public AdminUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        userModels = new ArrayList<>();
        for (int i = 0; i < Name.length; i++) {
            model_user UserModelForRecyclerView = new model_user(IMAGE[i], Name[i], country[i]);
            userModels.add(UserModelForRecyclerView);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users_admin, container, false);
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
        LinearLayout ln;
        public UsersHolder(View view) {
            super(view);
            userimage = (de.hdodenhof.circleimageview.CircleImageView) view.findViewById(R.id.personimage);
            username = (TextView) view.findViewById(R.id.username);
            usercounrty = (TextView) view.findViewById(R.id.usercountry);
            ln = (LinearLayout) view.findViewById(R.id.linearLayoutUser);

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
            holder.ln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AdminUpdateUser.class);
                    startActivity(intent);
//                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
//                    alertDialog.setTitle("Confirm Delete...");
//                    alertDialog.setMessage("Are you sure you want delete this?");
//                    alertDialog.setIcon(R.drawable.delete);
//                    alertDialog.setPositiveButton("YES",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    // Write your code here to execute after dialog
//                                    Toast.makeText(getActivity(), "You clicked on YES", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                    alertDialog.setNegativeButton("NO",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    // Write your code here to execute after dialog
//
//                                    dialog.cancel();
//                                }
//                            });
//
//                    // Showing Alert Message
//                    alertDialog.show();
                }
            });


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
