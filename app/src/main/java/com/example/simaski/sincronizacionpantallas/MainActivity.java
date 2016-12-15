package com.example.simaski.sincronizacionpantallas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.simaski.sincronizacionpantallas.CLS.ClientSocket;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btSincronizar)
    Button btSincronizar;

    private String server;
    private int port;
    private String mensajeRecibido;
    private String message;
    private String idGrupo;
    private String idPantalla;
    private String clase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        message = "2" + "|" + "1" + "|" + "chao";
        port = 9090;


    }

    @OnClick(R.id.btSincronizar)
    public void onClick() {
        Toast.makeText(this, "Sincronizacion Hecha!!!", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().postSticky(new Desesperado("172.17.177.16", port,"2" + "|" + "1" + "|" + "chao"));
        EventBus.getDefault().postSticky(new DesesperadoUno("172.17.177.4", port,"2" + "|" + "6" + "|" + "chao"));
        EventBus.getDefault().postSticky(new DesesperadoDos( "172.17.177.5", port,"2" + "|" + "7" + "|" + "chao"));
        EventBus.getDefault().postSticky(new DesesperadoTres( "172.17.177.6", port,"2" + "|" + "2" + "|" + "chao"));
        EventBus.getDefault().postSticky(new DesesperadoCuatro( "172.17.177.7", port,"2" + "|" + "5" + "|" + "chao"));
        /*EventBus.getDefault().postSticky(new DesesperadoCinco( "172.17.177.8", port,"2" + "|" + "3" + "|" + "chao"));*/
        EventBus.getDefault().postSticky(new DesesperadoSeis( "172.17.177.9", port,"2" + "|" + "4" + "|" + "chao"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Desesperado(Desesperado event) {

        server = event.getServer();
        port = event.getPort();
        message = event.getMessage();

        ClientSocket myClient = new ClientSocket(server, port, message);
        myClient.execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void DesesperadoUno(DesesperadoUno event) {

        server = event.getServer();
        port = event.getPort();
        message = event.getMessage();

        ClientSocket myClient = new ClientSocket(server, port, message);
        myClient.execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void DesesperadoDos(DesesperadoDos event) {

        server = event.getServer();
        port = event.getPort();
        message = event.getMessage();

        ClientSocket myClient = new ClientSocket(server, port, message);
        myClient.execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void DesesperadoTres(DesesperadoTres event) {

        server = event.getServer();
        port = event.getPort();
        message = event.getMessage();

        ClientSocket myClient = new ClientSocket(server, port, message);
        myClient.execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void DesesperadoCuatro(DesesperadoCuatro event) {

        server = event.getServer();
        port = event.getPort();
        message = event.getMessage();

        ClientSocket myClient = new ClientSocket(server, port, message);
        myClient.execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void DesesperadoCinco(DesesperadoCinco event) {

        server = event.getServer();
        port = event.getPort();
        message = event.getMessage();

        ClientSocket myClient = new ClientSocket(server, port, message);
        myClient.execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void DesesperadoSeis(DesesperadoSeis event) {

        server = event.getServer();
        port = event.getPort();
        message = event.getMessage();

        ClientSocket myClient = new ClientSocket(server, port, message);
        myClient.execute();
    }


}
