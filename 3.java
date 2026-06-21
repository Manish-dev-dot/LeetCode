public class ListNode {
    String sub="";
    ListNode next;
    ListNode() {}
    ListNode(String sub) { this.sub = sub; }
    ListNode(String sub, ListNode next) { this.sub = sub; this.next = next; }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        ListNode l1=new ListNode();
        int max=0;
        for(char c:s.toCharArray()){
            if(l1.sub.contains(String.valueOf(c))){
                l1.next=new ListNode(l1.sub.substring(l1.sub.lastIndexOf(c)+1)+String.valueOf(c));l1=l1.next;continue;
            }else{
                l1.sub=l1.sub+c;
                if(max<l1.sub.length()) max=l1.sub.length();
            }
        }   
        return max;
    }
}