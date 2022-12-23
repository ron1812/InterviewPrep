package com.practice.tree;

public class Trie {

    public Node root;

    public Trie() {
       root = new Node('*');
    }

    public void insert(String word) {
        Node currentNode = root;

        for(int i=0; i < word.length() ; i++){
            char ch = word.charAt(i);

            if(currentNode.child[ch - 'a'] == null){
                currentNode.child[ch - 'a'] = new Node(ch);
            }
            currentNode = currentNode.child[ch - 'a'];
        }
        currentNode.isEnd = true;
    }

    public boolean search(String word) {
        Node currentNode = root;

        for(int i=0; i < word.length() ; i++){
            char ch = word.charAt(i);

            if(currentNode.child[ch - 'a'] == null){
                return false;
            }
            currentNode = currentNode.child[ch - 'a'];
        }
        if(!currentNode.isEnd){
            return false;
        }else{
            return true;
        }
    }

    public boolean searchWithWildcardV2(String word) {
        return root.findElem(word,0);
    }

//    public boolean searchWithWildcard(String word) {
//        Node currentNode = root;
//
//        for(int i=0; i < word.length() ; i++){
//            char ch = word.charAt(i);
//
//            if(ch == '.'){
//                return findElem(currentNode,word,i);
//            }
//
//            if(currentNode.child[ch - 'a'] == null){
//                return false;
//            }
//            currentNode = currentNode.child[ch - 'a'];
//        }
//        if(!currentNode.isEnd){
//            return false;
//        }else{
//            return true;
//        }
//    }
//
//    //Coded by me
//    public boolean findElem(Node currentNode,String word,int i) {
//        Node[] currNodeChildArr = currentNode.child;
//        here : for(int j=0; j < currNodeChildArr.length; j++){
//            currentNode = currNodeChildArr[j];
//            if(currentNode != null){
//                for(int k = i+1 ;k<word.length();k++){
//                    Node[] childOfChildArr = currentNode.child;
//                    if(word.charAt(k) == '.'){
//                        if(findElem(currentNode,word,k))
//                            return true;
//                        else
//                            continue here;
//                    }else {
//                        if(childOfChildArr[word.charAt(k) - 'a'] == null){
//                            continue here;
//                        }
//                        currentNode = childOfChildArr[word.charAt(k) - 'a'];
//                    }
//                }
//                if(!currentNode.isEnd){
//                    return false;
//                }else{
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean startsWith(String prefix) {
        Node currentNode = root;

        for(int i=0; i < prefix.length() ; i++){
            char ch = prefix.charAt(i);

            if(currentNode.child[ch - 'a'] == null){
                return false;
            }
            currentNode = currentNode.child[ch - 'a'];
        }
        return true;
    }

      //Search word without wildcard
//    public static void main(String[] args) {
//        Trie obj = new Trie();
//        obj.insert("word");
//        obj.insert("rohan");
//        obj.insert("jessy");
//        obj.insert("god");
//        System.out.println("Is wor present "+obj.search("wor"));
//        System.out.println("Is rohan present "+obj.search("rohan"));
//        System.out.println("Is john present "+obj.search("john"));
//        System.out.println("Is jes present "+obj.search("jes"));
//        System.out.println("Is god present "+obj.search("god"));
//
//        System.out.println("Is prefix jes present "+obj.startsWith("jes"));
//        System.out.println("Is prefix ro present "+obj.startsWith("ro"));
//        System.out.println("Is prefix ron present "+obj.startsWith("ron"));
//    }

    //Search word with wildcard
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("c");
        obj.insert("mat");
        System.out.println("Is .at present "+obj.searchWithWildcardV2(".at"));
        System.out.println("Is m.t present "+obj.searchWithWildcardV2("m.t"));
        System.out.println("Is m. present "+obj.searchWithWildcardV2("m."));
        System.out.println("Is ma. present "+obj.searchWithWildcardV2("ma."));
        System.out.println("Is matt present "+obj.searchWithWildcardV2("matt"));
        System.out.println("Is ..t present "+obj.searchWithWildcardV2("..t"));
        System.out.println("Is m.. present "+obj.searchWithWildcardV2("m.."));
        System.out.println("Is ...t present "+obj.searchWithWildcardV2("...t"));
    }
}

class Node{

    public Node[] child;
    public boolean isEnd;
    public char data;

    public Node(char data){
        child = new Node[26];
        this.data = data;
    }

    public boolean findElem(String word,int i) {
        if(i == word.length()){
            return isEnd;
        }

        if(word.charAt(i) == '.'){
            for(Node childNode : child){
                if(childNode!=null && childNode.findElem(word,i+1)){
                    return true;
                };
            }
            return false;
        }else{
            if(child[word.charAt(i) - 'a'] != null){
                return child[word.charAt(i) - 'a'].findElem(word,i+1);
            }else{
                return false;
            }
        }
    }
}
