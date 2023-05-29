package holy.swing;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import holy.dao.FilmDAO;
import holy.dao.HMemberDAO;
import holy.dao.ScheduleDAO;
import holy.vo.FilmVO;
import holy.vo.HmemberVO;
import holy.vo.ScheduleVO;

import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

public class Lesson {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson window = new Lesson();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lesson() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 743, 410);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner.setBounds(109, 372, 86, 19);
		panel.add(spinner);
		
		spinner.addChangeListener((ChangeListener) new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("spinner value : "+spinner.getValue());
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("영화 목록\r\n");
		lblNewLabel.setBounds(85, 57, 97, 23);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("예매하기");
		btnNewButton.setBounds(613, 372, 97, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("날짜 선택");
		lblNewLabel_1.setBounds(316, 61, 57, 15);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 86, 194, 242);
		panel.add(scrollPane);
		
		JList list = new JList<Object>();
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel() {
			//String[] values = new String[] {"스크롤 생기는거 확인했고", "여기다가 영화목록 이름", "받아와서 출력"};
			String[] values = slist.toArray(new String[slist.size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
            //list 목록중에 하나 클릭하면 텍스트필드에 해당 주소값 나옴
				testLabel.setText( (String)list.getSelectedValue() );
			}
		});
		
		
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel_2 = new JLabel("인원 수");
		lblNewLabel_2.setBounds(40, 376, 57, 15);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(263, 86, 194, 242);
		panel.add(scrollPane_1);
		
		JList dateList = new JList();
		dateList.setModel(new AbstractListModel() {
			String[] values = new String[] {"2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13", "2023-05-13"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		dateList.setValueIsAdjusting(true);
		dateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dateList.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
            //list 목록중에 하나 클릭하면 텍스트필드에 해당 주소값 나옴
				dateLabel.setText( (String)dateList.getSelectedValue() );
			}
		});
		
		
		scrollPane_1.setViewportView(dateList);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(504, 86, 194, 242);
		panel.add(scrollPane_1_1);
		
		JList theaterList = new JList();
		scrollPane_1_1.setViewportView(theaterList);
		theaterList.setValueIsAdjusting(true);
		theaterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel secpanel = new JPanel();
		secpanel.setLayout(null);
		secpanel.setBounds(0, 0, 743, 410);
		frame.getContentPane().add(secpanel);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 0, 57, 15);
		secpanel.add(lblNewLabel_5);
		
		
		FilmDAO filmdao = new FilmDAO();
		List<FilmVO> filmList = filmdao.getMovie();
		List<String> slist = new ArrayList();
		for (FilmVO vo : filmList) {
			slist.add(vo.getFiltitle());
		}
		
		
		
		
		
		
	}
}
