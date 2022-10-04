package model;

public class Staff {
	private int id;
	
	private String hoTen;
	
	private String gioiTinh;
	
	private String sdt;
	
	private String ngaySinh;
	
	private String ma;
	
	private String matKhau;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int id, String hoTen, String gioiTinh, String sdt, String ngaySinh, String ma, String matKhau) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.ma = ma;
		this.matKhau = matKhau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
}


