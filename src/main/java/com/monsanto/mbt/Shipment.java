package com.monsanto.mbt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shipment {
	public List<Widget> sortWidgetByDate(List<Widget> widgetList) {

		Collections.sort(widgetList, new Comparator<Widget>() {

			@Override
			public int compare(Widget w1, Widget w2) {
				return w1.getProductionDate().compareTo(w2.getProductionDate());
			}
		});
		return widgetList;

	}

	public List<Widget> sortWidgetByColor(List<Widget> widgetList) {
		Collections.sort(widgetList, new Comparator<Widget>() {

			@Override
			public int compare(Widget w1, Widget w2) {
				return w1.getColor().compareTo(w2.getColor());
			}
		});
		return widgetList;
	}

	public static void main(String[] args) throws ParseException {
		Shipment shipment = null;
		String pattern = "d/M/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		shipment = new Shipment();
		List<Widget> widgetList = new ArrayList();
		widgetList.add(new Widget(1, "Red", sdf.parse("1/1/2006")));
		widgetList.add(new Widget(2, "Blue", sdf.parse("2/1/2007")));
		widgetList.add(new Widget(3, "Red", sdf.parse("3/1/2006")));
		widgetList.add(new Widget(4, "Green", sdf.parse("4/1/2009")));
		widgetList.add(new Widget(5, "Green", sdf.parse("5/1/2011")));
		System.out.println("----------By Date Sorting------------------ ");
		List<Widget> widgetListByDate = shipment.sortWidgetByDate(widgetList);
		for (Widget widget : widgetListByDate) {
			System.out.println(
					widget.getSerialNumber() + " " + widget.getColor() + " " + sdf.format(widget.getProductionDate()));
		}
		System.out.println("----------By Color Sorting------------------ ");
		List<Widget> widgetListByColor = shipment.sortWidgetByColor(widgetList);

		for (Widget widget : widgetListByColor) {
			System.out.println(
					widget.getSerialNumber() + " " + widget.getColor() + " " + sdf.format(widget.getProductionDate()));
		}
	}
}
