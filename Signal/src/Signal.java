import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;


public class Signal {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Signal window = new Signal();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		
		final Button btnPressMe = new Button(shell, SWT.NONE);
		btnPressMe.setBounds(72, 112, 75, 25);
		btnPressMe.setText("PRESS ME");
		
		final Label redLight = new Label(shell, SWT.NONE);
		redLight.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		redLight.setBounds(296, 171, 55, 40);
		redLight.setVisible(false);
		
		final Label amberLight = new Label(shell, SWT.NONE);
		amberLight.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		amberLight.setBounds(296, 112, 55, 40);
		amberLight.setVisible(false);
		
		final Label greenLight = new Label(shell, SWT.NONE);
		greenLight.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		greenLight.setBounds(296, 50, 55, 40);
		System.out.println("Green on");
		
		btnPressMe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					//btnPressMe.setGrayed(true);
					Thread.sleep(5000);
					greenLight.setVisible(false);
					System.out.println("Amber on");
					amberLight.setVisible(true);
					
					Thread.sleep(5000);
					amberLight.setVisible(false);
					redLight.setVisible(true);
					System.out.println("Red on");
					
					Thread.sleep(5000);
					redLight.setVisible(false);
					System.out.println("Amber flashing");
					for (int i = 0; i < 10; i++ ){
						amberLight.setVisible(true);
						Thread.sleep(250);
						amberLight.setVisible(false);
						Thread.sleep(250);
						}
					greenLight.setVisible(true);
					System.out.println("Green on");
				}
				catch (InterruptedException ex){
				}
				}
		});
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
