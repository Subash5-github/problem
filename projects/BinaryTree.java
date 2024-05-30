class Bnode{
int value;
Bnode left,right;
Bnode(int value){
  this.value=value;
}
}
class Binarytree{
	Bnode root;
	Binarytree(int val){
	 root = new Bnode(val);
	}
	Binarytree(){
	root=null;
	}
void add(int val){
	 add(root,val);
	}
	Bnode add(Bnode root,int val){
	if(root==null){
	return new Bnode(val);
	}
	if(val>root.value){
	root.right=add(root.right,val);
	}
	else if(val<root.value){
	root.left=add(root.left,val);
	}
	else if(root.value==val){
	return root;
	}
	else{
	return root;
	}
	return root;
	}

   Bnode search(int val){
	return search(root,val);
        }
   Bnode search(Bnode root,int val){

	if(root==null || root.value==val){
	return root;
	}
	if(val>root.value){
	return search(root.right,val);
	}
	else{
	return search(root.left,val);
	}

	}
	void delete(int val){
	delete(root,val);
	}

   Bnode delete(Bnode root,int val){
   if(root==null){
   return root;
   }
   if(val>root.value){
   root.right=delete(root.right,val);
   }
   else if(val<root.value){
   root.left=delete(root.left,val);
   }
   else{
   if(root.left==null){
   return root.right;
   }
   else if(root.right==null){
   return root.left;
   }
   else{
    root.value=min(root.right);
   root.right=delete(root.right,root.value);
   }
 
   }
    return root;
   }
   
   public int min(Bnode root){
   int minval=root.value;
   if(root.left!=null){
   minval=root.left.value;
   root=root.left;
   }
   return root.value;
   }
    String inorder(Bnode root){
	if(root!=null){
	inorder(root.left);
	System.out.println(root.value+" ");
	inorder(root.right);
	}
	return " ";
	}

   public String toString(){
        return inorder(root);
}

}

class BinaryTree{
public static void main(String[] args){
Binarytree b=new Binarytree(40);
b.add(30);
b.add(20);
b.add(100);
b.add(30);
b.add(56);

b.inorder(b.root);

b.delete(100);
System.out.println("after remove");
System.out.println(b);
if(b.search(54)==null){
System.out.println("not found");
}
else{
System.out.println("found");
}
b.inorder(b.root);
}
}
