package com.dosen.pmb;

import java.util.List;

public class ResponDaftar {
    String kode,pesan,respon;

    List<DataPendaftar> result;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getRespon() {
        return respon;
    }

    public void setRespon(String respon) {
        this.respon = respon;
    }

    public List<DataPendaftar> getResult() {
        return result;
    }

    public void setResult(List<DataPendaftar> result) {
        this.result = result;
    }
}
