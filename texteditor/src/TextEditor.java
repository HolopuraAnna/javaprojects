import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

/**
 * This class implements a simple Text Editor application with additional features.
 */
public class TextEditor extends JFrame implements ActionListener, WindowListener {
    /** Container for the current file name. */		
	File fnameContainer;
    /** Text area for user input. */
	JTextArea jta  =new JTextArea();

    /**
     * Window deactivated event handler.
     *
     * @param e WindowEvent instance
     */
	public void windowDeactivated(WindowEvent e) {}

    /**
     * Window activated event handler.
     *
     * @param e WindowEvent instance
     */
	public void windowActivated(WindowEvent e) {}

    /**
     * Window deiconified event handler.
     *
     * @param e WindowEvent instance
     */
	public void windowDeiconified(WindowEvent e) {}

    /**
     * Window iconified event handler.
     *
     * @param e WindowEvent instance
     */
	public void windowIconified(WindowEvent e) {}

    /**
     * Window closed event handler.
     *
     * @param e WindowEvent instance
     */
	public void windowClosed(WindowEvent e) {}

    /**
     * Window closing event handler.
     *
     * @param e WindowEvent instance
     */
	public void windowClosing(WindowEvent e) {
        Exiting();
    }

    /**
     * Window opened event handler.
     *
     * @param e WindowEvent instance
     */
	public void windowOpened(WindowEvent e) {}

    /**
     * Exits the application.
     */
    public void Exiting() {System.exit(0);}

    /**
     * Constructs an instance of the TextEditor class.
     */
	public TextEditor(){

		Font fnt=new Font("Arial",Font.PLAIN,15);
		Container con=getContentPane();		
		JMenuBar jmb=new JMenuBar();
		JMenu jmfile = new JMenu("File");
		JMenu jmedit = new JMenu("Edit");
		JMenu jmhelp = new JMenu("Help");
        JMenu jmcount = new JMenu("Statistics");
        JMenu jmsearch = new JMenu("Search Regex");
		
		con.setLayout(new BorderLayout());
		JScrollPane sbrText = new JScrollPane(jta);
		sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sbrText.setVisible(true);				
		jta.setFont(fnt);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);		
		con.add(sbrText);
		createMenuItem(jmfile,"New");
		createMenuItem(jmfile,"Open");
		createMenuItem(jmfile,"Save");
		jmfile.addSeparator();
		createMenuItem(jmfile,"Exit");		
		createMenuItem(jmedit,"Cut");
		createMenuItem(jmedit,"Copy");
		createMenuItem(jmedit,"Paste");		
		createMenuItem(jmhelp,"About Notepad");
        createMenuItem(jmcount,"Count Vowels");
        createMenuItem(jmcount,"Count Special Symbols");
        createMenuItem(jmcount,"Count Word Frequencies");
        createMenuItem(jmcount,"Count Letter Frequencies");
        createMenuItem(jmsearch,"Search Regex");
		jmb.add(jmfile);
		jmb.add(jmedit);
        jmb.add(jmcount);
        jmb.add(jmsearch);
		jmb.add(jmhelp);		
		setJMenuBar(jmb);
		addWindowListener(this);
		setSize(500,500);
		setTitle("Untitled.txt - Notepad");				
		setVisible(true);	
	}

    /**
     * Edits the specified file.
     *
     * @param fname File name to edit
     * @throws IOException If an I/O error occurs
     */
	public void EditFile(String fname) throws IOException {	
		BufferedReader d=new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
		String s;
		jta.setText("");	
		setCursor(new Cursor(Cursor.WAIT_CURSOR));		
		while((s=d.readLine())!= null) {
			jta.setText(jta.getText()+s+"\r\n");
		}	
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		d.close();
	}

    /**
     * Creates a menu item and adds it to the specified menu.
     *
     * @param jm  Menu to add the item
     * @param txt Text for the menu item
     */
	public void createMenuItem(JMenu jm,String txt){
		JMenuItem jmi=new JMenuItem(txt);
		jmi.addActionListener(this);
		jm.add(jmi);
	}

    /**
     * Saves the file with the specified name.
     *
     * @param fname File name to save
     * @throws IOException If an I/O error occurs
     */
	public void SaveFileAs(String fname) throws IOException {
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(fname));
		dos.writeBytes(jta.getText());
		dos.close();		
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

    int countVowels() {
        String text = jta.getText();
        int count = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        
        return count;
    }

    private void writeVowelCountToFile(int count) {
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showSaveDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                writer.println("Number of vowels: " + count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    int countSpecialSymbols() {
        String text = jta.getText();
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                count++;
            }
        }

        return count;
    }

    private void writeSymbolsCountToFile(int count) {
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showSaveDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                writer.println("Number of special symbols: " + count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    Map<String, Integer> countWordFrequencies() {
        String text = jta.getText();
        String[] words = text.split("\\s+");
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            word = word.toLowerCase();

            if (!word.isEmpty()) {
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequencyMap;
    }

    Map<Character, Integer> countLetterFrequencies() {
        String text = jta.getText();
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterFrequencyMap.put(c, letterFrequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        return letterFrequencyMap;
    }

    private void writeLetterFrequencyToFile(Map<Character, Integer> letterFrequencyMap) {
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showSaveDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                for (Map.Entry<Character, Integer> entry : letterFrequencyMap.entrySet()) {
                    writer.println(entry.getKey() + ": " + entry.getValue());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeWordFrequencyToFile(Map<String, Integer> wordFrequencyMap) {
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showSaveDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                    writer.println(entry.getKey() + ": " + entry.getValue());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Searches the text for a given regular expression and highlights matches.
     */
    private void searchRegex() {
        String regex = JOptionPane.showInputDialog(this, "Enter regular expression to search:");
    
        if (regex != null && !regex.isEmpty()) {
            Highlighter highlighter = jta.getHighlighter();
            DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
    
            try {
                highlighter.removeAllHighlights();
    
                String text = jta.getText();
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(text);
    
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    highlighter.addHighlight(start, end, painter);
                }
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles the action events.
     *
     * @param e ActionEvent instance
     */
	public void actionPerformed(ActionEvent e){	
		JFileChooser jfc=new JFileChooser();
		
		if(e.getActionCommand().equals("New")){ 
			this.setTitle("Untitled.txt - Notepad");
			jta.setText("");
			fnameContainer=null;		
		}
		else if(e.getActionCommand().equals("Open")){
			int ret=jfc.showDialog(null,"Open");			
			if(ret == JFileChooser.APPROVE_OPTION)
			{
				try{
					File fyl=jfc.getSelectedFile();
					OpenFile(fyl.getAbsolutePath());
					this.setTitle(fyl.getName()+ " - Notepad");
					fnameContainer=fyl;
				}
				catch(IOException ers){}
			}
			
		}
		else if(e.getActionCommand().equals("Save")){
			if(fnameContainer != null){
				jfc.setCurrentDirectory(fnameContainer);		
				jfc.setSelectedFile(fnameContainer);
			}
			else {
				jfc.setSelectedFile(new File("Untitled.txt"));
			}
			
			int ret=jfc.showSaveDialog(null);				
			if(ret == JFileChooser.APPROVE_OPTION){
				try{
					
					File fyl=jfc.getSelectedFile();
					SaveFile(fyl.getAbsolutePath());
					this.setTitle(fyl.getName()+ " - Notepad");
					fnameContainer=fyl;				
				}
				catch(Exception ers2){}
			}			
		}
		else if(e.getActionCommand().equals("Exit")){
			Exiting();
		}
		else if(e.getActionCommand().equals("Copy")){
			jta.copy();
		}
		else if(e.getActionCommand().equals("Paste")){
			jta.paste();
		}
		else if(e.getActionCommand().equals("About Notepad")){ 
			JOptionPane.showMessageDialog(this,"","Notepad",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand().equals("Cut")){
			jta.cut();
		}
        else if (e.getActionCommand().equals("Count Vowels")) {
            int vowelCount = countVowels();
            JOptionPane.showMessageDialog(this, "Number of vowels: " + vowelCount,
                    "Count Vowels", JOptionPane.INFORMATION_MESSAGE);
            writeVowelCountToFile(vowelCount);
        }
        else if (e.getActionCommand().equals("Count Special Symbols")) {
            int specialSymbolsCount = countSpecialSymbols();
            JOptionPane.showMessageDialog(this, "Number of special symbols: " + specialSymbolsCount,
                    "Count Special Symbols", JOptionPane.INFORMATION_MESSAGE);
            writeSymbolsCountToFile(specialSymbolsCount);
        }
        else if (e.getActionCommand().equals("Count Word Frequencies")) {
            Map<String, Integer> wordFrequencyMap = countWordFrequencies();
            JOptionPane.showMessageDialog(this, "Word frequencies counted. Check the file for results.",
                    "Count Word Frequencies", JOptionPane.INFORMATION_MESSAGE);
            writeWordFrequencyToFile(wordFrequencyMap);
        }
        else if (e.getActionCommand().equals("Count Letter Frequencies")) {
            Map<Character, Integer> letterFrequencyMap = countLetterFrequencies();
            JOptionPane.showMessageDialog(this, "Letter frequencies counted. Check the file for results.",
                    "Count Letter Frequencies", JOptionPane.INFORMATION_MESSAGE);
            writeLetterFrequencyToFile(letterFrequencyMap);
        }
        else if (e.getActionCommand().equals("Search Regex")) {
            searchRegex();
        }
	}
	
    /**
     * Opens the specified file for editing.
     *
     * @param fname File name to open
     * @throws IOException If an I/O error occurs
     */
	public void OpenFile(String fname) throws IOException {	
		BufferedReader d=new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
		String s;
		jta.setText("");	
		setCursor(new Cursor(Cursor.WAIT_CURSOR));		
		while((s=d.readLine())!= null) {
			jta.setText(jta.getText()+s+"\r\n");
		}	
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		d.close();
	}
	
    /**
     * Saves the file with the specified name.
     *
     * @param fname File name to save
     * @throws IOException If an I/O error occurs
     */
	public void SaveFile(String fname) throws IOException {
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(fname));
		dos.writeBytes(jta.getText());
		dos.close();		
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

}
