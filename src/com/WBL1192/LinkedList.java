package com.WBL1192;

public class LinkedList {
    private Node Head;

    public LinkedList() {
    }

    public void insertHead(String data){
        Node temp = new Node(data);
        temp.setNext(this.Head);
        this.Head = temp;
    }

    public void insertMiddle(String data, int pos){
        try{
            Node temp = new Node(data);
            int i = 0;
            Node curr = this.Head;
            while (i!=pos){
                curr = curr.getNext();
                i+=1;
            }
            temp.setNext(curr.getNext());
            curr.setNext(temp);
        }catch (Exception e){
            //jalanin ini
            System.out.println("Posisi diluar Linked List");
        }
    }

    public void  insertTail(String data){
        if(this.Head == null){
            insertHead(data);
            return;
        }
        Node temp = new Node(data);
        Node curr = this.Head;
        while (curr.getNext() != null){
            curr = curr.getNext();
        }
        curr.setNext(temp);
    }

    public boolean removeNode(int pos){
        if(pos==0){
            //apus Node pertama / Head
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
        String out = "Isi linkedlist: ";
        Node curr = this.Head;
        while (curr!=null){
            out = out + curr.toString();
            curr = curr.getNext();
        }
        return out;
    }
}
