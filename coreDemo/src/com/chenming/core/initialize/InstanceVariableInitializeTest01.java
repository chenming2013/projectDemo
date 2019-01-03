package com.chenming.core.initialize;

/**
 * 这是测试 实例变量 初始化
 * @author Lenovo
 *	【参考：http://blog.csdn.net/ECH00O00/article/details/74560535】
 */
class Tag{  
    Tag(int marker){  
        System.out.println("Tag("+marker+")");  
    }  
}  
class Card{  
    Tag t1 = new Tag(1);  
    Card(){  
        System.out.println("Card()");  
        t3 = new Tag(33);  
    }  
    Tag t2 = new Tag(2);  
    void f(){  
        System.out.println("f()");  
    }  
    Tag t3 = new Tag(3);  
}
public class InstanceVariableInitializeTest01
{
	public static void main(String[] args)
	{
		Card t =new Card();  
	    t.f();
	    /**
	     * 输出：
	     * 	Tag(1)
			Tag(2)
			Tag(3)
			Card()
			Tag(33)
			f()
	     */
	    
	    /**
	     * 总结：
	     * 	1.在未调用构造器之前,实例变量仍会进行一次编译器的默认初始化,在进行对象创建的时候,会先对变量进行一次显式初始化,再进行对象的创建
	     */
	}
}

  