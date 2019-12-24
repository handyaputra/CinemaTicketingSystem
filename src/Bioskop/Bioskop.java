package Bioskop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.SystemColor;


public class Bioskop extends JFrame{

	private JFrame frame;
	private JTextField textNama;
	private JTextField textJmlKursi;
	private JTextField textTotal;
	private String t = "0";
	private Integer i = 0, j, k;
	private Integer[][] seat = new Integer[6][8];

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Bioskop() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null, "Selamat Datang di Bioskop Studio XII");
					frame.setVisible(true);
					frame.setTitle("Bioskop XII");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		initialize();
		for (j=1; j<=5; j++) {
			for (k=1; k<=7; k++) {
				seat[j][k] = 0;
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\AA Project\\fix\\video-camera.png"));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 845, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel upFrame = new JLabel("New label");
		upFrame.setIcon(new ImageIcon("src\\Bioskop\\Capture.PNG"));
		upFrame.setBounds(0, 0, 823, 74);
		frame.getContentPane().add(upFrame);
		
		JPanel panelPesan = new JPanel();
		panelPesan.setBackground(SystemColor.controlDkShadow);
		panelPesan.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPesan.setBounds(10, 90, 363, 330);
		frame.getContentPane().add(panelPesan);
		panelPesan.setLayout(null);
		
		JLabel lblNama = new JLabel("Nama Pemesan");
		lblNama.setForeground(SystemColor.text);
		lblNama.setBounds(10, 47, 119, 14);
		panelPesan.add(lblNama);
		
		JLabel lblJudulFilm = new JLabel("Judul Film");
		lblJudulFilm.setForeground(SystemColor.text);
		lblJudulFilm.setBounds(10, 77, 106, 14);
		panelPesan.add(lblJudulFilm);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setForeground(SystemColor.text);
		lblTanggal.setBounds(10, 107, 72, 30);
		panelPesan.add(lblTanggal);
		
		JLabel lblJamTayang = new JLabel("Jam Tayang");
		lblJamTayang.setForeground(SystemColor.text);
		lblJamTayang.setBounds(10, 153, 106, 17);
		panelPesan.add(lblJamTayang);
		
		JLabel lblJumlahKursi = new JLabel("Jumlah Kursi");
		lblJumlahKursi.setForeground(SystemColor.text);
		lblJumlahKursi.setBounds(10, 186, 119, 23);
		panelPesan.add(lblJumlahKursi);
		
		JLabel lblTotalHarga = new JLabel("Total Harga");
		lblTotalHarga.setForeground(SystemColor.text);
		lblTotalHarga.setBounds(10, 225, 94, 14);
		panelPesan.add(lblTotalHarga);
		
		JLabel lblRp = new JLabel("Rp");
		lblRp.setForeground(SystemColor.text);
		lblRp.setBounds(104, 225, 46, 14);
		panelPesan.add(lblRp);
		
		JComboBox cmbJudul = new JComboBox();
		cmbJudul.setModel(new DefaultComboBoxModel(new String[] {"Pilih Judul Film", "The Avengers : Infinity War", "Venom", "Aquaman", "Ant Man & The Wasp", "The Incredible 2"}));
		cmbJudul.setBounds(156, 81, 162, 20);
		panelPesan.add(cmbJudul);
		
		JComboBox cmbJam = new JComboBox();
		cmbJam.setModel(new DefaultComboBoxModel(new String[] {"Pilih Jam", "14.00 WIB", "16.00 WIB", "19.00 WIB", "21.00 WIB"}));
		cmbJam.setBounds(156, 150, 94, 20);
		panelPesan.add(cmbJam);
		
		JDateChooser dcTanggal = new JDateChooser();
		dcTanggal.setBounds(156, 117, 181, 20);
		panelPesan.add(dcTanggal);
		
		textNama = new JTextField();
		textNama.setBounds(156, 45, 181, 20);
		panelPesan.add(textNama);
		textNama.setColumns(10);
		
		textJmlKursi = new JTextField();
		textJmlKursi.setColumns(10);
		textJmlKursi.setBounds(156, 186, 94, 20);
		panelPesan.add(textJmlKursi);
		textJmlKursi.setText(t);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int harga = 0;
				if (cmbJam.getSelectedItem() == "14.00 WIB") {
					harga = 20000;
				} else if (cmbJam.getSelectedItem() == "16.00 WIB") {
					harga = 25000;
				} else if (cmbJam.getSelectedItem() == "19.00 WIB") {
					harga = 30000;
				} else if (cmbJam.getSelectedItem() == "21.00 WIB") {
					harga = 35000;
				}
				if (cmbJudul.getSelectedItem() == "The Avengers : Infinity War") {
					harga += 10000;
				} else if (cmbJudul.getSelectedItem() == "Venom") {
					harga += 5000;
				}
				int jml = Integer.parseInt(textJmlKursi.getText());
				textTotal.setText((harga*jml) + "");
			}
		});
		btnTotal.setBounds(253, 185, 84, 23);
		panelPesan.add(btnTotal);
		
		textTotal = new JTextField();
		textTotal.setColumns(10);
		textTotal.setBounds(156, 222, 181, 20);
		panelPesan.add(textTotal);
		
		JButton btnPesanTiket = new JButton("Pesan Tiket");
		btnPesanTiket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nama = textNama.getText();
					Object judul = cmbJudul.getSelectedItem();
					String tampilan = "dd-MM-yyyy";
					SimpleDateFormat format = new SimpleDateFormat(tampilan);
					String tanggal = String.valueOf(format.format(dcTanggal.getDate()));
					String kursi = ""; char ch;
					Object tayang = cmbJam.getSelectedItem();
					String total = textTotal.getText();
					
					for (j=1; j<=4; j++) {
						for (k=1; k<=7; k++) {
							if (seat[j][k] == 1) {
								ch = (char)(64 + j);
								kursi += ch;
								ch = (char)(48 + k);
								kursi += ch + " ";
							}
						}
					}
					
					Document doc = new Document();
					PdfWriter.getInstance(doc, new FileOutputStream("Ticket.pdf"));
					doc.open();
					doc.add(new Paragraph("========================================"));
					doc.add(new Paragraph("               Bioskop XII              "));
					doc.add(new Paragraph("          Surakarta Grand Mall          "));
					doc.add(new Paragraph("========================================"));
					
					doc.add(new Paragraph("Nama         : " + nama));
					doc.add(new Paragraph("Judul Film   : " + judul));
					doc.add(new Paragraph("Tanggal      : " + tanggal));
					doc.add(new Paragraph("Jam Tayang   : " + tayang));
					doc.add(new Paragraph("Nomor Kursi  : " + kursi));
					
					doc.add(new Paragraph("========================================"));
					doc.add(new Paragraph("Total Harga  : Rp " + total));
					doc.add(new Paragraph("========================================"));
					doc.close();
					
					JOptionPane.showMessageDialog(null, "Tiket Berhasil Dipesan :)");
					
				} catch(Exception evt) {
					System.out.println(evt.getMessage());
				}
			}
		});
		btnPesanTiket.setBounds(15, 291, 136, 23);
		panelPesan.add(btnPesanTiket);
		
		JButton btnKeluar = new JButton("Keluar");
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(236, 291, 101, 23);
		panelPesan.add(btnKeluar);
		
		JLabel lblNewLabel_1 = new JLabel("*Catatan : Harap mengisi form dengan sebenar-benarnya.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(10, 255, 338, 20);
		panelPesan.add(lblNewLabel_1);
		
		JLabel lblFormPemesanan = new JLabel("FORM PEMESANAN");
		lblFormPemesanan.setBounds(92, 0, 172, 29);
		panelPesan.add(lblFormPemesanan);
		lblFormPemesanan.setForeground(SystemColor.info);
		lblFormPemesanan.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		
		JPanel panelKursi = new JPanel();
		panelKursi.setBackground(new Color(240, 248, 255));
		panelKursi.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelKursi.setBounds(383, 90, 421, 330);
		frame.getContentPane().add(panelKursi);
		panelKursi.setLayout(null);
		
		JButton btnA1 = new JButton("A1");
		btnA1.addActionListener(new ActionListener() {
			Boolean cek = true;
			public void actionPerformed(ActionEvent arg0) {
				if (cek == true) {
					btnA1.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][1] = 1;
				} else {
					btnA1.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][1] = 0;
				}
			}
		});
		btnA1.setBackground(Color.LIGHT_GRAY);
		btnA1.setForeground(Color.BLACK);
		btnA1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA1.setBounds(10, 120, 46, 23);
		panelKursi.add(btnA1);
		
		JButton btnA2 = new JButton("A2");
		btnA2.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnA2.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][2] = 1;
				} else {
					btnA2.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][2] = 0;
				}
			}
		});
		btnA2.setBackground(Color.LIGHT_GRAY);
		btnA2.setForeground(Color.BLACK);
		btnA2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA2.setBounds(66, 120, 46, 23);
		panelKursi.add(btnA2);
		
		JButton btnA3 = new JButton("A3");
		btnA3.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnA3.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][3] = 1;
				} else {
					btnA3.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
				}
			}
		});
		btnA3.setBackground(Color.LIGHT_GRAY);
		btnA3.setForeground(Color.BLACK);
		btnA3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA3.setBounds(122, 120, 46, 23);
		panelKursi.add(btnA3);
		
		JButton btnA4 = new JButton("A4");
		btnA4.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnA4.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][4] = 1;
				} else {
					btnA4.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][4] = 0;
				}
			}
		});
		btnA4.setBackground(Color.LIGHT_GRAY);
		btnA4.setForeground(Color.BLACK);
		btnA4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA4.setBounds(178, 120, 46, 23);
		panelKursi.add(btnA4);

		JButton btnA5 = new JButton("A5");
		btnA5.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnA5.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][5] = 1;
				} else {
					btnA5.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][5] = 0;
				}
			}
		});
		btnA5.setBackground(Color.LIGHT_GRAY);
		btnA5.setForeground(Color.BLACK);
		btnA5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA5.setBounds(253, 120, 46, 23);
		panelKursi.add(btnA5);
		
		JButton btnA6 = new JButton("A6");
		btnA6.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnA6.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][6] = 1;
				} else {
					btnA6.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][6] = 0;
				}
			}
		});
		btnA6.setBackground(Color.LIGHT_GRAY);
		btnA6.setForeground(Color.BLACK);
		btnA6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA6.setBounds(309, 120, 46, 23);
		panelKursi.add(btnA6);
		
		JButton btnA7 = new JButton("A7");
		btnA7.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnA7.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][7] = 1;
				} else {
					btnA7.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[1][7] = 0;
				}
			}
		});
		btnA7.setBackground(Color.LIGHT_GRAY);
		btnA7.setForeground(Color.BLACK);
		btnA7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA7.setBounds(365, 120, 46, 23);
		panelKursi.add(btnA7);
		
		JButton btnB1 = new JButton("B1");
		btnB1.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnB1.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][1] = 1;
				} else {
					btnB1.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][1] = 0;
				}
			}
		});
		btnB1.setBackground(Color.LIGHT_GRAY);
		btnB1.setForeground(Color.BLACK);
		btnB1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB1.setBounds(10, 176, 46, 23);
		panelKursi.add(btnB1);
		
		JButton btnB2 = new JButton("B2");
		btnB2.setBackground(Color.LIGHT_GRAY);
		btnB2.setForeground(Color.BLACK);
		btnB2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB2.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent arg0) {
				if (cek == true) {
					btnB2.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][2] = 1;
				} else {
					btnB2.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][2] = 0;
				}
			}
		});
		btnB2.setBounds(66, 176, 46, 23);
		panelKursi.add(btnB2);
		
		JButton btnB3 = new JButton("B3");
		btnB3.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnB3.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][3] = 1;
				} else {
					btnB3.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][3] = 0;
				}
			}
		});
		btnB3.setBackground(Color.LIGHT_GRAY);
		btnB3.setForeground(Color.BLACK);
		btnB3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB3.setBounds(122, 176, 46, 23);
		panelKursi.add(btnB3);
		
		JButton btnB4 = new JButton("B4");
		btnB4.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnB4.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][4] = 1;
				} else {
					btnB4.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][4] = 0;
				}
			}
		});
		btnB4.setBackground(Color.LIGHT_GRAY);
		btnB4.setForeground(Color.BLACK);
		btnB4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB4.setBounds(178, 176, 46, 23);
		panelKursi.add(btnB4);
		
		JButton btnB5 = new JButton("B5");
		btnB5.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnB5.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][5] = 1;
				} else {
					btnB5.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][5] = 0;
				}
			}
		});
		btnB5.setBackground(Color.LIGHT_GRAY);
		btnB5.setForeground(Color.BLACK);
		btnB5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB5.setBounds(253, 176, 46, 23);
		panelKursi.add(btnB5);
		
		JButton btnB6 = new JButton("B6");
		btnB6.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnB6.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][6] = 1;
				} else {
					btnB6.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][6] = 0;
				}
			}
		});
		btnB6.setBackground(Color.LIGHT_GRAY);
		btnB6.setForeground(Color.BLACK);
		btnB6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB6.setBounds(309, 176, 46, 23);
		panelKursi.add(btnB6);
		
		JButton btnB7 = new JButton("B7");
		btnB7.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnB7.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][7] = 1;
				} else {
					btnB7.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[2][7] = 0;
				}
			}
		});
		btnB7.setBackground(Color.LIGHT_GRAY);
		btnB7.setForeground(Color.BLACK);
		btnB7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB7.setBounds(365, 176, 46, 23);
		panelKursi.add(btnB7);
		
		JButton btnC1 = new JButton("C1");
		btnC1.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnC1.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][1] = 1;
				} else {
					btnC1.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][1] = 0;
				}
			}
		});
		btnC1.setBackground(Color.LIGHT_GRAY);
		btnC1.setForeground(Color.BLACK);
		btnC1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC1.setBounds(10, 230, 46, 23);
		panelKursi.add(btnC1);
		
		JButton btnC2 = new JButton("C2");
		btnC2.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnC2.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][2] = 1;
				} else {
					btnC2.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][2] = 0;
				}
			}
		});
		btnC2.setBackground(Color.LIGHT_GRAY);
		btnC2.setForeground(Color.BLACK);
		btnC2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC2.setBounds(66, 230, 46, 23);
		panelKursi.add(btnC2);
		
		JButton btnC3 = new JButton("C3");
		btnC3.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnC3.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][3] = 1;
				} else {
					btnC3.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][3] = 0;
				}
			}
		});
		btnC3.setBackground(Color.LIGHT_GRAY);
		btnC3.setForeground(Color.BLACK);
		btnC3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC3.setBounds(122, 230, 46, 23);
		panelKursi.add(btnC3);
		
		JButton btnC4 = new JButton("C4");
		btnC4.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnC4.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][4] = 1;
				} else {
					btnC4.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][4] = 0;
				}
			}
		});
		btnC4.setBackground(Color.LIGHT_GRAY);
		btnC4.setForeground(Color.BLACK);
		btnC4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC4.setBounds(178, 230, 46, 23);
		panelKursi.add(btnC4);
		
		JButton btnC5 = new JButton("C5");
		btnC5.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnC5.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][5] = 1;
				} else {
					btnC5.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][5] = 0;
				}
			}
		});
		btnC5.setBackground(Color.LIGHT_GRAY);
		btnC5.setForeground(Color.BLACK);
		btnC5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC5.setBounds(253, 230, 46, 23);
		panelKursi.add(btnC5);
		
		JButton btnC6 = new JButton("C6");
		btnC6.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnC6.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][6] = 1;
				} else {
					btnC6.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][6] = 0;
				}
			}
		});
		btnC6.setBackground(Color.LIGHT_GRAY);
		btnC6.setForeground(Color.BLACK);
		btnC6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC6.setBounds(309, 230, 46, 23);
		panelKursi.add(btnC6);
		
		JButton btnC7 = new JButton("C7");
		btnC7.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnC7.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][7] = 1;
				} else {
					btnC7.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[3][7] = 0;
				}
			}
		});
		btnC7.setBackground(Color.LIGHT_GRAY);
		btnC7.setForeground(Color.BLACK);
		btnC7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC7.setBounds(365, 230, 46, 23);
		panelKursi.add(btnC7);
		
		JButton btnD1 = new JButton("D1");
		btnD1.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnD1.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][1] = 1;
				} else {
					btnD1.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][1] = 0;
				}
			}
		});
		btnD1.setBackground(Color.LIGHT_GRAY);
		btnD1.setForeground(Color.BLACK);
		btnD1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD1.setBounds(10, 278, 46, 23);
		panelKursi.add(btnD1);
		
		JButton btnD2 = new JButton("D2");
		btnD2.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnD2.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][2] = 1;
				} else {
					btnD2.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][2] = 0;
				}
			}
		});
		btnD2.setBackground(Color.LIGHT_GRAY);
		btnD2.setForeground(Color.BLACK);
		btnD2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD2.setBounds(66, 278, 46, 23);
		panelKursi.add(btnD2);
		
		JButton btnD3 = new JButton("D3");
		btnD3.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnD3.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][3] = 1;
				} else {
					btnD3.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][3] = 0;
				}
			}
		});
		btnD3.setBackground(Color.LIGHT_GRAY);
		btnD3.setForeground(Color.BLACK);
		btnD3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD3.setBounds(122, 278, 46, 23);
		panelKursi.add(btnD3);
		
		JButton btnD4 = new JButton("D4");
		btnD4.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnD4.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][4] = 1;
				} else {
					btnD4.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][4] = 0;
				}
			}
		});
		btnD4.setBackground(Color.LIGHT_GRAY);
		btnD4.setForeground(Color.BLACK);
		btnD4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD4.setBounds(178, 278, 46, 23);
		panelKursi.add(btnD4);
		
		JButton btnD5 = new JButton("D5");
		btnD5.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnD5.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][5] = 1;
				} else {
					btnD5.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][5] = 0;
				}
			}
		});
		btnD5.setBackground(Color.LIGHT_GRAY);
		btnD5.setForeground(Color.BLACK);
		btnD5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD5.setBounds(253, 278, 46, 23);
		panelKursi.add(btnD5);
		
		JButton btnD6 = new JButton("D6");
		btnD6.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnD6.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][6] = 1;
				} else {
					btnD6.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][6] = 0;
				}
			}
		});
		btnD6.setBackground(Color.LIGHT_GRAY);
		btnD6.setForeground(Color.BLACK);
		btnD6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD6.setBounds(309, 278, 46, 23);
		panelKursi.add(btnD6);
		
		JButton btnD7 = new JButton("D7");
		btnD7.addActionListener(new ActionListener() {
			boolean cek = true;
			public void actionPerformed(ActionEvent e) {
				if (cek == true) {
					btnD7.setBackground(Color.RED);
					cek = false;
					i++;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][7] = 1;
				} else {
					btnD7.setBackground(Color.LIGHT_GRAY);
					cek = true;
					i--;
					t = Integer.toString(i);
					textJmlKursi.setText(t);
					seat[4][7] = 0;
				}
			}
		});
		btnD7.setBackground(Color.LIGHT_GRAY);
		btnD7.setForeground(Color.BLACK);
		btnD7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD7.setBounds(365, 278, 46, 23);
		panelKursi.add(btnD7);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 396, 36);
		panelKursi.add(panel);
		
		JLabel lblLayar = new JLabel("LAYAR");
		panel.add(lblLayar);
		lblLayar.setForeground(new Color(0, 0, 0));
		lblLayar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\AA Project\\fix\\8728.png"));
		lblBackground.setBounds(0, 0, 814, 431);
		frame.getContentPane().add(lblBackground);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("src\\Bioskop\\bgg.PNG"));
		background.setBounds(0, 0, 823, 439);
		frame.getContentPane().add(background);
		
		
	}
}