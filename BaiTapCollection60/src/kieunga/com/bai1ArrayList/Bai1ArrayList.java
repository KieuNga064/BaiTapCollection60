package kieunga.com.bai1ArrayList;

import java.util.ArrayList;
import java.util.Scanner;


public class Bai1ArrayList {

	static ArrayList<String> dsSV=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		do
		{
			menu();
		}
		while(true);
				
								

	}
	
	static void menu()
	{
		System.out.println("Mời bạn chọn chức năng:");
		System.out.println("1.Thêm Sinh viên");
		System.out.println("2.Xuất danh sách Sinh viên");
		System.out.println("3.Sửa Sinh viên");
		System.out.println("4.Xóa Sinh viên bất kì");
		System.out.println("5.Tìm Sinh viên tên có chữ An");
		System.out.println("6.Sắp xếp Sinh viên");
		System.out.println("7.Xuất ra số lượng Sinh viên");
		System.out.println("8.Thoát");
		int kq=new Scanner(System.in).nextInt();
		switch (kq)
		{
		case 1:
			themSinhVien();
			break;
		case 2:
			xuatDSSV();
			break;
		case 3:
			suaSinhVien();
			break;
		case 4:
			xoaSinhVien();
			break;	
		case 5:
			timSinhVienTenCoChuAn();
			break;
		case 6:
			sapXepSinhVien();
			break;
		case 7:
			xuatSoLuongSinhVien();
			break;
		case 8:
			System.out.println("Tạm biệt.");
			System.exit(0);
		}
	}

	private static void xuatSoLuongSinhVien() {
		System.out.println("Số sinh viên là: "+dsSV.size());
		
	}

	private static void sapXepSinhVien() {
		String []ten1; 
		String []ten2;
		for (int i = 0; i < dsSV.size(); i++) 
		{
			for(int j=(dsSV.size()-1) ; j>i;j--)				
			{
				ten1=(dsSV.get(j)).split(" ");
				ten2=(dsSV.get(j-1)).split(" ");
				if(ten1[ten1.length-1].compareTo(ten2[ten2.length-1])<0)
				{
					dsSV.add(j-1, dsSV.get(j));
					dsSV.remove(j+1);
				}
				else if(ten1[ten1.length-1].compareTo(ten2[ten2.length-1])<0)
				{
					if(ten1[0].compareTo(ten2[0])<0)
					{
						dsSV.add(j-1, dsSV.get(j));
						dsSV.remove(j+1);
					}
				}
			}	
		}
		System.out.println("Danh sách sau sắp xếp (sắp theo tên và họ):");
		for(String p:dsSV)
			System.out.println(p);		
	}


	private static void timSinhVienTenCoChuAn() {
		System.out.println("Danh sách sinh viên tên chứa chữ An là:");
			for (int i = 0; i < dsSV.size(); i++) 
			{
				String sv=dsSV.get(i);
				if(sv.contains("An"))
					System.out.println(sv);
			}		
	}

	private static void xoaSinhVien() {
		System.out.println("Mời bạn nhập vào từ cần xóa:");
		String ten=new Scanner(System.in).nextLine();
		ten=ten.trim();
		ArrayList<Integer> vtCanXoa=new ArrayList<>();
		for (int i = 0; i < dsSV.size(); i++)
		{
			String b=dsSV.get(i);
			if(b.contains(ten))
			{
				vtCanXoa.add(i);
			}			
		}
		if(vtCanXoa.size()==0)
		{
			System.out.println("Không tìm thấy sinh viên tên có chứa từ trên.");
		}
		else 
		{
		for(int i=0;i<vtCanXoa.size();i++) 
		{
			System.out.println("Xóa "+dsSV.get(vtCanXoa.get(i)-i));
			dsSV.remove(vtCanXoa.get(i)-i);			
		}
		System.out.println("Đã xóa các sinh viên tên có chứa ["+ten+"]");		
		}
		
	}

	private static void suaSinhVien() {
		if(dsSV.size()==0)
			System.out.println("Không có sinh viên nào, mời bạn nhập thêm.");
		else
		{
		System.out.println("Danh sách sinh viên đã nhập:");
		for (int i = 0; i < dsSV.size(); i++)
		{
			System.out.println((i+1)+"\t"+dsSV.get(i));
		}
		System.out.println("-------------------");
		System.out.println("Chọn Sinh viên bạn muốn sửa: ");
		int vt=sc.nextInt();		
		while(!nhapDung(vt, dsSV.size()))
		{
			System.out.println("Nhập sai, mời bạn nhập lại:");
			vt=sc.nextInt();
		}
		
		System.out.println("Nhập tên mới:");
		String ten=new Scanner(System.in).nextLine();
		dsSV.set(vt-1, ten);
		System.out.println("Đã sửa thành công.");
		}
	}

	private static void xuatDSSV() {
		if(dsSV.size()==0)
			System.out.println("Không có sinh viên nào, mời bạn nhập thêm.");
		else
		{
		System.out.println("Danh sách sinh viên: ");
		for(String p:dsSV)
		{
			System.out.println(p);
		}
		}
	}

	private static void themSinhVien() {
		System.out.println("Mời bạn nhập tên Sinh viên: ");
		String ten = sc.nextLine();
		dsSV.add(ten);		
	}
	static Boolean nhapDung(int vt,int doDai)
	{
		Boolean kt=true;
		if(vt>doDai || vt<1)
			kt=false;
		return kt;
	}
}
