package AdminFragments;


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

import AdminModels.model_package;
import io.google.gp_11.AdminAddPackageActivity;
import io.google.gp_11.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminPackagesFragment extends Fragment {

    private String[] Start = {"Start 1/6/2017 12:00", "Start 5/6/2017 12:00", "Start 7/6/2017 12:00"};
    private String[] End = {"End 8/6/2017 12:00", "End 8/6/2017 12:00", "End 8/6/2017 12:00"};
    private String[] pckgname = {"Package1", "Package2", "Package3"};
    private String[] placesinpackage = {"pyramids ,sinai", "Helwan ,sinai", "Cairo Tower"};
    private String[] TIME = {"6h 21m", "8h 11m", "4h 40m"};
    private String[] PRICE = {"21,685 USD", "45,421 USD", "22,500 USD"};

    private ArrayList<model_package> packageModels;
    private RecyclerView recyclerView;
    private fragment_package_adapter PackageAdapter;

    public AdminPackagesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        packageModels = new ArrayList<>();
        for (int i = 0; i < Start.length; i++) {
            model_package PackageModelForRecyclerView = new model_package(pckgname[i], placesinpackage[i], Start[i], End[i], TIME[i], PRICE[i]);
            packageModels.add(PackageModelForRecyclerView);
        }
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_packages_admin, container, false);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setImageResource(R.drawable.addpackage);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(getActivity(), AdminAddPackageActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewPackages);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        PackageAdapter = new fragment_package_adapter(packageModels);
        recyclerView.setAdapter(PackageAdapter);
    }

    private class PackagesHolder extends RecyclerView.ViewHolder {
        TextView end;
        TextView start;
        TextView pckname;
        TextView placesingpckg;
        TextView time;
        TextView price;
        // LinearLayout ln;
        public PackagesHolder(View view) {
            super(view);
            start = (TextView) view.findViewById(R.id.start);
            end = (TextView) view.findViewById(R.id.end);
            pckname = (TextView) view.findViewById(R.id.pckgname);
            placesingpckg = (TextView) view.findViewById(R.id.placesinpckg);
            time = (TextView) view.findViewById(R.id.timetostart);
            price = (TextView) view.findViewById(R.id.price);
//                ln = (LinearLayout) view.findViewById(R.id.total);
        }
    }

    private class fragment_package_adapter extends RecyclerView.Adapter<PackagesHolder> {
        private ArrayList<model_package> models;

        public fragment_package_adapter(ArrayList<model_package> Models) {
            models = Models;
        }

        @Override
        public PackagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.recycler_view_packages, parent, false);
            return new PackagesHolder(view);
        }

        @Override
        public void onBindViewHolder(PackagesHolder holder, int position) {
            final model_package modela = models.get(position);
            holder.pckname.setText(modela.getPckgname());
            holder.placesingpckg.setText(modela.getPlacesinpckg());
            holder.start.setText(modela.getStart());
            holder.end.setText((modela.getEnd()));
            holder.time.setText(modela.getTime());
            holder.price.setText(modela.getPrice());
//            holder.ln.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,DetailsActivity.class);
//                intent.putExtra("started",movie.getStart());
//                context.startActivity(intent);
//            }
//        });

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