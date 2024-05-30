class MapNode{
MapNode right,left;
int key;
	MapNode(int value){
	key=value;
	}
}

class Treemap{
MapNode root;
   Treemap(int value){
   root=new MapNode(value);
   }
void add(int key){
add(root,key);

}
	MapNode add(MapNode root,int key){
	if(root==null){
	return new MapNode(key);
	}
	 if(key>root.key){
	root.right=add(root.right,key);
	}
	else if(key<root.key){
	root.left=add(root.left,key);
	}
        else{
        return root;
        }
        return root;
	}
	
	
	
	MapNode search(MapNode root,int value){
	if(root==null|| root.key==value){
	return root;
	}
	else if(value>root.key){
	return search(root.right,value);
	}
	else{
	return search(root.left,value);
	}
	}
	
	
	public void inorder(MapNode root){
	if(root!=null){
	inorder(root.left);
	System.out.println(root.key);
	inorder(root.right);
	}
	}
	
	public void delete(int value){
	delete(root,value);
	}
	
	MapNode delete(MapNode root,int value){
	if(root==null){
	return root;
	}
         if(value>root.key){
	root.right=delete(root.right,value);
	}
	else if(value<root.key){
	root.left=delete(root.left,value);
	}
	
	else{
	if(root.left==null){
	return root.right;
	}
	else if(root.right==null){
	return root.left;
	}
	else{
	  root.key=min(root.right);
	  root.right=delete(root.right,root.key);
	}
	}
	return root;
	}
	
	public int min(MapNode root){
	int minval=root.key;
	while(root.left!=null){
	minval=root.left.key;
	root=root.left;
	}
	return minval;
	}
}

class TreeMap{
public static void main(String[] args){
Treemap t=new Treemap(50);
t.add(50);
t.add(45);
t.add(90);
t.add(34);
t.add(56);
t.inorder(t.root);
t.delete(90);
System.out.println("after delete");
t.inorder(t.root);
if(t.search(t.root,90)==null){
System.out.println("not found");
}
else{
System.out.println("found");
}
}
}
