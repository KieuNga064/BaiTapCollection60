package kieunga.com.bai2HashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Bai2HashMap {

	static HashMap<String, String> dsSV=new HashMap<>();
	static ArrayList<String> msSV=new ArrayList<>();
	static Collection<String> dsTen=dsSV.values();
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
		System.out.println("2.Xuất danh sách Sinh viên (Mã và Tên)");
		System.out.println("3.Sửa Sinh viên");
		System.out.println("4.Xóa Sinh viên bất kì");
		System.out.println("5.Tìm Sinh viên tên có chữ An");
		System.out.println("6.Xuất ra các mã Sinh viên");
		System.out.println("7.Xuất ra các tên Sinh viên");
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
			xuatMaSinhVien();
			break;
		case 7:
			xuatTenSinhVien();
			break;
		case 8:
			System.out.println("Tạm biệt.");
			System.exit(0);
		}
	}

	private static void xuatTenSinhVien() {
		System.out.println("Các tên sinh viên:");
		for(String sv:dsTen) {
			System.out.println(sv);
		}
	}

	private static void xuatMaSinhVien() {
		System.out.println("Các mã sinh viên: ");
		for(String ms:msSV)
		{
			System.out.println(ms);
		}
		
	}

	private static void timSinhVienTenCoChuAn() {
		System.out.println("Các sinh viên tên chứa chữ An:");
		int dem=0;
		for(String ten:dsTen)
		{
			if(ten.contains("An"))
			{
				System.out.println(ten);
				dem++;
			}
		}
		if(dem==0)
			System.out.println("Không có sinh viên nào tên có chữ An.");
	}

	private static void xoaSinhVien() {
		System.out.println("Nhập tên Sv bạn muốn xóa: ");
		String ten=new Scanner(System.in).nextLine();		
		ArrayList<Integer> canXoa=new ArrayList<>();
		for (int i=0;i<msSV.size();i++)
		{
			String ms=msSV.get(i);
			if((dsSV.get(ms)).contains(ten))	
				canXoa.add(i);
		}
		if(canXoa.size()==0)
		{
			System.out.println("Không tìm thấy sinh viên tên có chứa từ trên.");
		}
		else 
		{
		for(int i=0;i<canXoa.size();i++) 
		{
			String ms=msSV.get(canXoa.get(i)-i);					
			System.out.println("Xóa "+dsSV.get(ms));
			dsSV.remove(ms);	
			msSV.remove(canXoa.get(i)-i);
		}
		System.out.println("Đã xóa các sinh viên tên có chứa ["+ten+"]");		
		}
		
	}

	private static void suaSinhVien() {
		if(dsSV.size()==0)
			System.out.println("Không có sinh viên nào, mời bạn nhập thêm.");
		else
		{
		xuatDSSV();
		System.out.println("-------------------");
		System.out.println("Nhập mã số SV bạn muốn sửa: ");
		String ms=new Scanner(System.in).nextLine();		
		if(dsSV.containsKey(ms))
		{
		System.out.println("Nhập tên mới:");
		String ten=new Scanner(System.in).nextLine();
		dsSV.put(ms, ten);
		System.out.println("Đã sửa thành công.");
		}
		else
			System.out.println("Không tìm thấy sv có mã "+ms);		
		}
		
	}

	private static void xuatDSSV() {
		System.out.println("Danh sách sinh viên đã nhập:");	
		for (String ms:msSV)
		{
			System.out.println(ms+"\t"+dsSV.get(ms));
		}
		
	}

	private static void themSinhVien() {
		System.out.println("Mời bạn nhập MSSV:");
		String MSSV=new Scanner(System.in).nextLine();
		msSV.add(MSSV);
		System.out.println("Mời bạn nhập tên:");
		String ten=new Scanner(System.in).nextLine();
		dsSV.put(MSSV,ten);
		
	}
}
