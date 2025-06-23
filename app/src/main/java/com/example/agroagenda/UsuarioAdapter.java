package com.example.agroagenda;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private List<Usuario> listaUsuarios;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public UsuarioAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void actualizarLista(List<Usuario> nuevaLista) {
        this.listaUsuarios = nuevaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        //holder.textViewNombreApellido.setText(usuario.getNombre() + " " + usuario.getApellido());
        holder.textViewExtension.setText("Extensión: " + usuario.getExtension());
        holder.textViewPuesto.setText("Puesto: " + usuario.getPuesto());
        holder.textViewSucursal.setText("Sucursal: " + usuario.getSucursal());
        //holder.textViewDepartamento.setText("Departamento: " + usuario.getDepartamento());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombreApellido;
        public TextView textViewExtension;
        TextView textViewPuesto;
        TextView textViewSucursal;
        public TextView textViewDepartamento;

        public UsuarioViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            //textViewNombreApellido = itemView.findViewById(R.id.textViewNombreApellido);
            textViewExtension = itemView.findViewById(R.id.textViewExtension);
            textViewPuesto = itemView.findViewById(R.id.textViewPuesto);
            textViewSucursal = itemView.findViewById(R.id.textViewSucursal);
            //textViewDepartamento = itemView.findViewById(R.id.textViewDepartamento);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}