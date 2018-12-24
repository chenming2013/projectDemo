package basic.basic_05_1_spel;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 测试Spring表达式
 * @author 陈明
 * @date   2018年11月12日
 */
public class SpelTest
{

	/**
	 * 测试字面量表达式
	 * 	注意: 如果是字符串字面量,双引号里面一定要有引号
	 */
	/**
	 * 1.1 测试字符串字面量表达式
	 */
	@Test
	public void testLiteralExpressionOfString() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Hello world'");
		String value = expression.getValue(String.class);
		System.out.println(value);   //Hello world
	}
	/**
	 * 1.2 测试int型字面量表达式
	 */
	@Test
	public void testLiteralExpressionOfInt() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("1+2");
		Integer value = expression.getValue(int.class);
		System.out.println(value);	//3
	}
	/**
	 * 1.2.2 测试int型字面量表达式：使用不同的进制
	 * 	经测试,只有十六进制能够解析,二进制、八进制都忽略前面的0,知道遇到第一个非0的数,然后按照十进制解析
	 */
	@Test
	public void testLiteralExpressionOfInt_2() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("012");
		Integer value = expression.getValue(int.class);
		System.out.println(value);	//12
		
		Expression expression2 = parser.parseExpression("0010");
		Integer value2 = expression2.getValue(int.class);
		System.out.println(value2);		//10

		Expression expression3 = parser.parseExpression("0xa1");
		Integer value3 = expression3.getValue(int.class);
		System.out.println(value3);		//161 = 16 * 10 + 1
	}
	
	/**
	 * 1.3 测试Long型字谜那辆表达式
	 */
	@Test
	public void testLiteralExpressionOfLong() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("1+2L");
		Long value = expression.getValue(Long.class);
		System.out.println(value);	//3
		
		Expression expression2 = parser.parseExpression("0xaL");
		Long value2 = expression2.getValue(Long.class);
		System.out.println(value2);		//10
		
		/**
		 * 注意下面的D当成了十六进制的D来解析,而不是Double类型的D
		 */
		Expression expression3 = parser.parseExpression("0xad");
		Double value3 = expression3.getValue(Double.class);
		System.out.println(value3);		//173.0
	}
	
}
