package codegenerator.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import codegenerator.Generator;

public class GeneratorHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Teszt
		//System.out.println("Evil button pressed!");
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
	    if (window != null)
	    {
	    	
	    	IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        
	        //ha egy elem van kijelölve, akkor tudunk kezdeni valamit a generálással
	        if (selection.size() == 1) {
	        	Object firstElement = selection.getFirstElement();
	        	
	        	// Egy System van kiválasztva
	        	if(firstElement instanceof evilsystem.System){
	        		Generator generator = new Generator();
	        		generator.generateCodeFromInstance((evilsystem.System) firstElement);
	        		
	        	}
	        	// A root van kiválasztva
	        	else if (firstElement instanceof XMIResource) {
	        		XMIResource xmiResource = (XMIResource) firstElement;
	        		Generator generator = new Generator();
	        		if (xmiResource.getContents().get(0) instanceof evilsystem.System) {
	        			generator.generateCodeFromInstance((evilsystem.System)(xmiResource.getContents().get(0)));
	        		}
	        		else {
	        			showErrorMessage("System needed the root element!");
	        		}
	        	}
	        	// Valami más van kiválasztva
	        	else {
	        		showErrorMessage("Unkown element: "+firstElement);
	        	}
	        }
	        else {
	        	showErrorMessage("You have to select exactly one element!");
	        }
	    }
	    else {
	    	showErrorMessage("There isn't any active Workbench window!");
	    }
		
		return null;
	}
	
	public static void showErrorMessage(String errorMessage) {
		MessageDialog messageDialog = new MessageDialog(
			null,
			"Error during code generation",
			null,
			errorMessage,
			MessageDialog.ERROR,
			new String[]{":("}, 0);
		messageDialog.open();
	}
}
