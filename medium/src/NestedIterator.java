import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
//解题思路：在初始化时迭代器时直接把结果遍历出来
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
interface NestedInteger {

             // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();
             // @return the single integer that this NestedInteger holds, if it holds a single integer
             // Return null if this NestedInteger holds a nested list
            public Integer getInteger();
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
 }
public class NestedIterator implements Iterator<Integer> {
    private  List<Integer>list;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list=integerInterator(nestedList);
        index=-1;
    }
    @Override
    public boolean hasNext() {
        if (index>=list.size()-1)
        return false;
        else{
            return true;
        }
    }

    @Override
    public Integer next() {
        if (this.hasNext()) return list.get((++index));
        return null;
    }
    public static List<Integer>integerInterator(List<NestedInteger>nestedIntegerList){
        ArrayList<Integer>list=new ArrayList<>(nestedIntegerList.size());
        for (NestedInteger tmp :nestedIntegerList){
            if (tmp.isInteger()){
                list.add(tmp.getInteger());
            }else{
                list.addAll(integerInterator(tmp.getList()));
            }

        }
        return list;

    }
}
