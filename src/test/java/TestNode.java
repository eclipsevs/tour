import javax.xml.crypto.Data;

/**
 * @author wk
 * @date 2019/9/29  16:47
 */
public class TestNode {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            add(new Integer(i).toString());
        }
        insert(3,"7");
    }

    private static String result2;
    private static void insert(int i, String s) {
        if (head == null) {
            throw new NullPointerException("没有头结点");
        }
        Node temp = head;
        int count = 1;
        while (temp.next != null){
            if(i == ++count ){
                Node insertNode = new Node("7");
                insertNode.next = temp.next;
                temp.next = insertNode;
                break;
            }
            temp = temp.next;
        }
        result2 = head.data;
        temp = head;
        while (temp.next != null){
            temp = temp.next;
            result2+=temp.data;
        }
        System.out.println(result2);

    }

    private static String result = "";
    private static Node head;
    private static void add(String s) {
        if (head == null) {
            head = new Node(s);
            result = head.data;
        }else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(s);
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
            result += temp.data;
        }
        System.out.println(result);
        result = head.data;
    }

    private static class Node{
        public String data;
        private Node next;
        public Node(String data) {
            this.data = data;
        }
    }
}
