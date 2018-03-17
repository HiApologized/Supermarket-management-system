import java.util.ArrayList;
import java.util.Scanner;

public class FruitStore {

	public static void main(String[] args) {
		// 定义数组,记录每个商品信息
		ArrayList<FruitItem> list = new ArrayList<FruitItem>();
		/*
		 * 1.超市商品初始化
		 */
		init(list);

		while (true) {
			/*
			 * 2.显示主菜单
			 */
			mainMenu();
			/*
			 * 3.根据接收到的功能选项，执行对应的功能
			 */
			chooseFunction(list);
		}
	}

	public static void init(ArrayList<FruitItem> list) {
		FruitItem item = new FruitItem();
		item.name = "少林寺酥饼核桃";
		item.ID = 9001;
		item.price = 120;

		FruitItem item2 = new FruitItem();
		item2.name = "尚康杂粮牡丹饼";
		item2.ID = 9002;
		item2.price = 20;

		FruitItem item3 = new FruitItem();
		item3.name = "新疆原产哈密瓜";
		item3.ID = 3;
		item3.price = 9007;

		list.add(item);
		list.add(item2);
		list.add(item3);
	}

	public static void mainMenu() {
		System.out.println("=========================欢迎光临itcast超市=========================");
		System.out.println("1:查询货物  2：添加新货物 3:删除货物 4：修改货物");
		System.out.println("5：退出系统");
	}

	public static void chooseFunction(ArrayList<FruitItem> list) {
		System.out.println("请您输入要操作的功能序号：");
		Scanner sc = new Scanner(System.in);// 键盘输入对象
		String choose = sc.next();
		sc.close();
		// 根据接收到的选择，执行对应的功能
		switch (choose) {
		case "1": // 3.1.库存货物查询
			showFruitList(list);
			break;
		case "2": // 3.2.添加新货物
			addFruitItem(list);
			break;
		case "3": // 3.3.删除货物
			delFruitItem(list);
			break;
		case "4": // 3.4.修改货物
			updateFruitItem(list);
			break;
		case "5": // 3.5.退出系统,退出JVM
			System.out.println("退出系统");
			System.exit(0);
//			return;
//			这里的return有问题，return只会结束这个函数，main函数并不会结束
		default:
			System.out.println("对不起，没有您输入的功能，请重新选择");
			break;
		}
	}

	public static void showFruitList(ArrayList<FruitItem> list) {
		System.out.println("=======================商品库存清单=======================");
		System.out.println("商品编号\t商品名称\t\t商品单价");
		// 查询每种库存商品信息
		for (int i = 0; i < list.size(); i++) {
			FruitItem item = list.get(i);
			System.out.println(item.ID + "\t" + item.name + "\t" + item.price);
		}
	}

	public static void addFruitItem(ArrayList<FruitItem> list) {

		// 创建新获取对象
		FruitItem newItem = new FruitItem();
		Scanner sc = new Scanner(System.in);// 键盘输入对象
		// 提示输入信息
		System.out.print("请输入新水果的名称:");
		newItem.name = sc.next();
		System.out.print("请输入新水果的编号:");
		newItem.ID = sc.nextInt();
		System.out.print("请输入新水果单价:");
		newItem.price = sc.nextDouble();

		// 向货物集合中添加新的物品项
		list.add(newItem);
		sc.close();
	}

	public static void delFruitItem(ArrayList<FruitItem> list) {
		System.out.print("请输入您要删除的水果编号:");
		Scanner sc = new Scanner(System.in);//键盘输入对象
		int fruitID = sc.nextInt();
		sc.close();
		//删除集合元素
		for (int i = 0; i < list.size(); i++) {
			FruitItem thisItem = list.get(i);
			if(thisItem.ID == fruitID) {
				list.remove(thisItem);
				System.out.println("水果信息删除完毕!");
				return;
			}
		}
		System.out.println("对不起，没有这个编号的水果!");
	}

public static void updateFruitItem(ArrayList<FruitItem> list) {
		
		System.out.println();
		System.out.print("请输入您要修改信息的水果编号:");
		
		Scanner sc = new Scanner(System.in);//键盘输入对象
		int fruitID = sc.nextInt();
		
		//更新集合元素
		for (int i = 0; i < list.size(); i++) {
			
			FruitItem thisItem = list.get(i);
			if(thisItem.ID == fruitID) {
				System.out.print("请输入新的水果ID:");
				thisItem.ID = sc.nextInt();
				System.out.print("请输入新的水果名称:");
				thisItem.name = sc.next();
				System.out.print("请输入新的水果单价:");
				thisItem.price = sc.nextDouble();
				System.out.println("水果信息更新完毕!");
				sc.close();
				return;
			}
		}
		sc.close();
		System.out.println("对不起，没有这个编号的水果!");
	}
}
