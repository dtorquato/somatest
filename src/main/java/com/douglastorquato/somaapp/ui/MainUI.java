package com.douglastorquato.somaapp.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douglastorquato.somaapp.entity.Employee;
import com.douglastorquato.somaapp.entity.Transaction;
import com.douglastorquato.somaapp.services.EmployeeService;
import com.douglastorquato.somaapp.services.TransactionService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


@SpringUI(path="/example")
@Theme("valo")
public class MainUI extends UI{
	private static final long serialVersionUID = 1L;
	
	private VerticalLayout verticalLayout;
	private HorizontalLayout horizontalLayout;
	private Label header;
	private Layout mainLayout;
	private Layout formLayout;
	
	private Grid<Employee> employeeGrid;
	private ListDataProvider<Employee> empProvider;
	private List<Employee> gridEmployees;
	
	private Grid<Transaction> transactionGrid;
	private ListDataProvider<Transaction> traProvider;
	private List<Transaction> gridTransactions;
	private Button transactionButton;
	private Button employeeButton;
	private Integer soma;
	
	@Autowired
	private EmployeeService employeeService;	
	
	@Autowired
	private TransactionService transactionService;

	private HorizontalLayout gridLayout;

	private HorizontalLayout buttonsLayout;	
	
	
	@Override
	protected void init(VaadinRequest vaadinrequest) {
		this.gridEmployees = new ArrayList<>();
		this.empProvider = new ListDataProvider<>(this.gridEmployees);
		
		this.gridTransactions = new ArrayList<>();
		this.traProvider = new ListDataProvider<>(this.gridTransactions);
		
		this.verticalLayout = new VerticalLayout();
		this.verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		this.mainLayout = this.createMainLayout();
		
		this.verticalLayout.addComponent(this.mainLayout);
		this.verticalLayout.setSizeFull();
		
		setContent(this.verticalLayout);
	}


	private Layout createMainLayout() {
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		this.header = new Label("Portal Empresa - Soma");
		this.header.addStyleName(ValoTheme.LABEL_H1);
		
		this.buttonsLayout = this.createButtonsLayout();
		this.formLayout = this.createFormLayout();
		
		
		mainLayout.addComponent(this.header);
		mainLayout.addComponent(this.buttonsLayout);
		mainLayout.addComponent(this.formLayout);
		
		return mainLayout;
	}


	private HorizontalLayout createButtonsLayout() {
		HorizontalLayout buttonsLayout = new HorizontalLayout();
		buttonsLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		this.transactionButton = new Button("Extrato");
		this.employeeButton = new Button("Funcionários");
		buttonsLayout.addComponent(this.transactionButton);
		buttonsLayout.addComponent(this.employeeButton);
		
		return buttonsLayout;
	}


	private Layout createFormLayout() {
		VerticalLayout formLayout = new VerticalLayout();
		formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
			
		this.transactionGrid = createTransactionGrid();
		this.gridTransactions.addAll(this.transactionService.findAll());
		formLayout.addComponent(this.transactionGrid);
		
		this.transactionButton.addClickListener(click -> {
			//gridLayout.removeAllComponents();
			formLayout.removeAllComponents();
			this.gridTransactions.clear();
			this.transactionGrid = createTransactionGrid();
			this.gridTransactions.addAll(this.transactionService.findAll());
			formLayout.addComponent(this.transactionGrid);
			int sum = this.transactionService.findAll().stream().mapToInt(o->o.getValue()).sum();
			Label header = new Label("Saldo: " + sum);
	        header.addStyleName("green");
	        formLayout.addComponent(header);
			
		});
		
	
		this.employeeButton.addClickListener(click -> {
			//gridLayout.removeAllComponents();
			formLayout.removeAllComponents();
			this.gridEmployees.clear();
			this.employeeGrid = createEmployeeGrid();
			this.gridEmployees.addAll(this.employeeService.findAll());
			formLayout.addComponent(this.employeeGrid);

		});

		//formLayout.addComponent(horizontalLayout);
		//formLayout.addComponent(gridLayout);
		
		return formLayout;
	}


	private Grid<Employee> createEmployeeGrid() {
		Grid<Employee> grid = new Grid<>();
		//grid.setWidth("25%");
		grid.setHeight("");
		grid.setSelectionMode(SelectionMode.NONE);
		grid.setDataProvider(this.empProvider);
		
		grid.removeAllColumns();
		grid.addColumn(Employee::getId).setCaption("MATRÍCULA");//.setWidth(196)
		grid.addColumn(Employee::getName).setCaption("NOME");//.setWidth(220) 
		grid.addColumn(Employee::getRole).setCaption("FUNÇÃO");//.setWidth(144)

		
		return grid;
	}
	
	private Grid<Transaction> createTransactionGrid() {
		Grid<Transaction> grid = new Grid<>();
		//grid.setWidth("25%");
		grid.setHeight("");
		grid.setSelectionMode(SelectionMode.NONE);
		grid.setDataProvider(this.traProvider);
		
		grid.removeAllColumns();
		grid.addColumn(Transaction::getDateTransaction).setCaption("Data Operação");//.setWidth(196)
		grid.addColumn(Transaction::getType).setCaption("Tipo Operação");//.setWidth(220) 
		grid.addColumn(Transaction::getValue).setCaption("Valor Operação");//.setWidth(144)
		
		
		return grid;
	}

}
