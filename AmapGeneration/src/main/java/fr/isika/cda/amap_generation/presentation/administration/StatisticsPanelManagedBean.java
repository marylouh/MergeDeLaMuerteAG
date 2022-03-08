package fr.isika.cda.amap_generation.presentation.administration;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;

import fr.isika.cda.amap_generation.business.administration.StatisticsPanelService;

@Named
@RequestScoped
public class StatisticsPanelManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 12544584584L;
	
	@Inject
	private StatisticsPanelService statService;

	private LineChartModel amapGeneration2021;
	private LineChartModel amapGeneration2022;
	private BarChartModel activities2021;
	private BarChartModel activities2022;
	private LineChartModel orderMember2021;
	private LineChartModel orderMember2022;
	
	@PostConstruct
    public void init() {
		
	
		createLineModels();
		createBarModel();
		createorderMember2021();
	
	}
	
	public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void createLineModels() {
		amapGeneration2021 = initAmap2021();
		amapGeneration2021.setTitle("Inscriptions des amaps en 2021");
        amapGeneration2021.setLegendPosition("e");
        amapGeneration2021.setShowPointLabels(true);
        amapGeneration2021.getAxes().put(AxisType.X, new CategoryAxis("Mois"));
        Axis yAxis = amapGeneration2021.getAxis(AxisType.Y);
        yAxis.setLabel("Nb inscriptions");
        yAxis.setMin(0);
        yAxis.setMax(5);
        
        
        amapGeneration2022 = initAmap2022();
        amapGeneration2022.setTitle("Inscriptions des amaps en 2022");
        amapGeneration2022.setLegendPosition("e");
        amapGeneration2022.setShowPointLabels(true);
        amapGeneration2022.getAxes().put(AxisType.X, new CategoryAxis("Mois"));
        yAxis = amapGeneration2022.getAxis(AxisType.Y);
        yAxis.setLabel("Nb inscriptions");
        yAxis.setMin(0);
        yAxis.setMax(5);
        
	}
	
	private LineChartModel initAmap2021() {
        LineChartModel model = new LineChartModel();

        ChartSeries amaps = new ChartSeries();
        amaps.setLabel("Amap");
        
        String mois ="";
        for(int i=1; i<13; i++) {
        	mois =  String.valueOf(i);
        	
        	if(this.statService.getAllAmapsByMonth(i, 2021) !=null) {
        	amaps.set(mois, this.statService.getAllAmapsByMonth(i, 2021).size());
        	}
        	else {
        		amaps.set(mois, 0);
        	}
        }
              
        model.addSeries(amaps);

        return model;
    }
	
	private LineChartModel initAmap2022() {
        LineChartModel model = new LineChartModel();

        ChartSeries amaps = new ChartSeries();
        amaps.setLabel("Amap");
        
        String mois ="";
        for(int i=1; i<13; i++) {
        	mois =  String.valueOf(i);
        	
        	if(this.statService.getAllAmapsByMonth(i, 2022) !=null) {
        	amaps.set(mois, this.statService.getAllAmapsByMonth(i, 2022).size());
        	}
        	else {
        		amaps.set(mois, 0);
        	}
        }
              
        model.addSeries(amaps);

        return model;
    }
	
	
	private void createBarModel() {
		activities2021 = initActivity2021();

		activities2021.setTitle("Activités proposées en 2021");
		activities2021.setLegendPosition("ne");

        Axis xAxis = activities2021.getAxis(AxisType.X);
        xAxis.setLabel("Type d'activité");

        Axis yAxis = activities2021.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre d'activités");
        yAxis.setMin(0);
        yAxis.setMax(10);
        
        
        
        activities2022 = initActivity2022();

        activities2022.setTitle("Activités proposées en 2022");
        activities2022.setLegendPosition("ne");

        xAxis = activities2022.getAxis(AxisType.X);
        xAxis.setLabel("Type d'activité");

        yAxis = activities2022.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre d'activités");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

	
	private BarChartModel initActivity2021() {
        BarChartModel model = new BarChartModel();

        ChartSeries workshops = new ChartSeries();
        workshops.setLabel("Ateliers");
        
        String mois ="";
        for(int i=1; i<13; i++) {
        	mois =  String.valueOf(i);
        	
        	if(this.statService.getAllWorkshoptByMonth(i, 2021) !=null) {
        		workshops.set(mois, this.statService.getAllWorkshoptByMonth(i, 2021).size());
        	}
        	else {
        		workshops.set(mois, 0);
        	}
        }
    

        ChartSeries events = new ChartSeries();
        events.setLabel("Evenements");
        
        for(int i=1; i<13; i++) {
        	mois =  String.valueOf(i);
        	
        	if(this.statService.getAllEventByMonth(i, 2021) !=null) {
        		events.set(mois, this.statService.getAllEventByMonth(i, 2021).size());
        	}
        	else {
        		events.set(mois, 0);
        	}
        }
       
        model.addSeries(workshops);
        model.addSeries(events);

        return model;
    }
	
	
	private BarChartModel initActivity2022() {
        BarChartModel model = new BarChartModel();

        ChartSeries workshops = new ChartSeries();
        workshops.setLabel("Ateliers");
        
        String mois ="";
        for(int i=1; i<13; i++) {
        	mois =  String.valueOf(i);
        	
        	if(this.statService.getAllWorkshoptByMonth(i, 2022) !=null) {
        		workshops.set(mois, this.statService.getAllWorkshoptByMonth(i, 2022).size());
        	}
        	else {
        		workshops.set(mois, 0);
        	}
        }
    

        ChartSeries events = new ChartSeries();
        events.setLabel("Evenements");
        
        for(int i=1; i<13; i++) {
        	mois =  String.valueOf(i);
        	
        	if(this.statService.getAllEventByMonth(i, 2022) !=null) {
        		events.set(mois, this.statService.getAllEventByMonth(i, 2022).size());
        	}
        	else {
        		events.set(mois, 0);
        	}
        }
       
        model.addSeries(workshops);
        model.addSeries(events);

        return model;
    }
	
	
	private void createorderMember2021() {
        orderMember2021 = new LineChartModel();

        BarChartSeries members = new BarChartSeries();
        members.setLabel("Adhésions");

        String mois ="";
        for(int i=1; i<13; i++) {
        	mois =  String.valueOf(i);
        	
        	if(this.statService.getAllMembersByMonth(i, 2021) !=null) {
        		members.set(mois, this.statService.getAllMembersByMonth(i, 2022).size());
        	}
        	else {
        		members.set(mois, 0);
        	}
        }
        
        
        
        
        
        
        
        
        
        
        
        
        

//        LineChartSeries orders = new LineChartSeries();
//        orders.setLabel("Girls");
//        orders.setXaxis(AxisType.X);
//        orders.setYaxis(AxisType.Y);
//
//        for(int i=1; i<13; i++) {
//        	mois =  String.valueOf(i);
//        	
//        	if(this.statService.getAllOrdersByMonth(i, 2021) !=null) {
//        		orders.set(mois, this.statService.getAllOrdersByMonth(i, 2022).size());
//        	}
//        	else {
//        		orders.set(mois, 0);
//        	}
//        }
        
        
        orderMember2021.addSeries(members);
//        orderMember2021.addSeries(orders);

        orderMember2021.setTitle("Evolution du nombre d'adhérents et de commandes par adhérent");
        orderMember2021.setMouseoverHighlight(false);

        orderMember2021.getAxes().put(AxisType.X, new CategoryAxis("Mois"));
        orderMember2021.getAxes().put(AxisType.X2, new CategoryAxis(""));

        Axis yAxis = orderMember2021.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre de commandes");
        yAxis.setMin(0);
        yAxis.setMax(200);

        Axis y2Axis = new LinearAxis("Number");
        y2Axis.setMin(0);
        y2Axis.setMax(200);

        orderMember2021.getAxes().put(AxisType.Y2, y2Axis);
    }
	
	
	

	public LineChartModel getAmapGeneration2021() {
		return amapGeneration2021;
	}

	public LineChartModel getAmapGeneration2022() {
		return amapGeneration2022;
	}

	public BarChartModel getActivities2021() {
		return activities2021;
	}

	public BarChartModel getActivities2022() {
		return activities2022;
	}

	public LineChartModel getOrderMember2021() {
		return orderMember2021;
	}

	public LineChartModel getOrderMember2022() {
		return orderMember2022;
	}

	
	


	

}
