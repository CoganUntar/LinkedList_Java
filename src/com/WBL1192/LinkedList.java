package com.WBL1192;

public class LinkedList {
    private Node Head;

    public LinkedList() {
    }

    //nambahin Node di awal List
    public void insertHead(String data){
        Node temp = new Node(data);
        temp.setNext(this.Head);
        this.Head = temp;
    }

    //nambahin Node ditengah list dengan posisi tertentu
    public void insertMiddle(String data, int pos){
        try{
            //loop dari Node pertama
            Node temp = new Node(data);
            int i = 0;
            Node curr = this.Head;
            while (i!=pos){
                curr = curr.getNext();
                i+=1;
            }
            temp.setNext(curr.getNext());
            curr.setNext(temp);
        }catch (Exception e){ //Exception adalah code error yang biasa muncul di terminal, biasa berwarna merah
            //kalo error, kode ini bakal dijalanin
            System.out.println("Posisi diluar Linked List");
            //System.out.println(e); //kode untuk nampilin error code di terminal
        }
    }

    public void insertTail(String data){
        // kalo mau insert di akhir, tapi headnya masi kosong, sama aja kaya ngeinsert di awal/head
        if(this.Head == null){
            insertHead(data);
            return;
        }

        Node temp = new Node(data);
        Node curr = this.Head;
        //loop dari head, sampe ke akhir
        //node terakhir ga punya pointer next //getnext()!=null berarti punya pointer next
        while (curr.getNext() != null){
            curr = curr.getNext();
        }
        //bikin next node terakhir, ngepoint ke node yang baru dibentuk
        curr.setNext(temp);
    }

    public boolean removeNode(int pos){
        //kalo posisi yang mau diapus 0 berarti mau ngapus node head/ pertama
        if(pos==0){
            this.Head = this.Head.getNext();
            return true;
        }
        //apus node kedua sampai akhir
        pos = pos-1;
        try{
            int i = 0;
            Node curr = this.Head;
            while (i!=pos){
                curr = curr.getNext();
                i+=1;
            }
            curr.setNext( curr.getNext().getNext());
            return true;
        }catch (Exception e){
            //posisi yang mau diapus ada diluar linked list
            System.out.println("Posisi diluar Linked List");
            return false;
        }
    }

    public Node getNode(int pos){
        try{
            int i = 0;
            Node curr = this.Head;
            while (i!=pos){
                curr = curr.getNext();
                i+=1;
            }
            return curr;
        }catch (Exception e){
            System.out.println("Posisi diluar Linked List");
            return null;
        }
    }

    @Override
    public String toString() {
        //bikin variable String baru dulu
        String out = "Isi linkedlist: ";

        //tambahin isi data setiap node dalam linkedlist
        Node curr = this.Head;
        while (curr!=null){
            out = out + curr.toString();
            curr = curr.getNext();
        }

        //return variable Stringnya
        return out;
    }
}
