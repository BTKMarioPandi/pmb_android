package com.dosen.pmb;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterDaftar extends RecyclerView.Adapter<AdapterDaftar.HolderData> {

    private List<DataPendaftar> mlist;
    private Context ctx;

    public AdapterDaftar(Context ctx,List<DataPendaftar> mlist){
        this.ctx=ctx;
        this.mlist=mlist;
    }

    @NonNull
    @Override
    public AdapterDaftar.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_tampil_data,viewGroup,false);
        HolderData holder=new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDaftar.HolderData holderData, int i) {
        DataPendaftar df =mlist.get(i);
        holderData.nodaf.setText(df.getNo_pendaftaran());
        holderData.namasiswa.setText(df.getNama_calon_siswa());
        holderData.df=df;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView nodaf,namasiswa;
        DataPendaftar df;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            nodaf=(TextView)itemView.findViewById(R.id.tvno);
            namasiswa=(TextView)itemView.findViewById(R.id.tvnama);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent godaftar=new Intent(ctx,Register.class);
                    godaftar.putExtra("noo",df.getNo_pendaftaran());
                    godaftar.putExtra("naamaa",df.getNama_calon_siswa());

                    ctx.startActivity(godaftar);
                }
            });




        }
    }
}
