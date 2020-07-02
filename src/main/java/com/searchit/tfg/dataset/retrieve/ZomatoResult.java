package com.searchit.tfg.dataset.retrieve;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ZomatoResult {

    private final ZomatoWebOrder zomatoWebOrder;

    public ZomatoResult(ZomatoWebOrder zomato) {
        this.zomatoWebOrder= zomato;
    }

    public void ID(String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).timeout(90000).get();

            assert doc != null;
            Elements scriptElements = doc.getElementsByTag("script");

            for (Element element :scriptElements ){
                for (DataNode node : element.dataNodes()) {
                    if(node.toString().contains("res_id")){
                        String data = node.getWholeData();
                        String[] split = data.split("\n");
                        for(String i :split){
                            if(i.contains("res_id")) {
                                String[] JsonData = i.split(":");
                                for(int j=0; j<JsonData.length;j++){
                                    if(JsonData[j].contains("res_id")){
                                        String[] res_idWhole = JsonData[j+1].split(",");
                                        zomatoWebOrder.setRestaurantID(res_idWhole[0]);
                                        return ;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (HttpStatusException e){
            if(e.getStatusCode()==404){
                System.out.println("Error 404: Result not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void Name(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void CountryCode(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void City(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void ThumbNail(String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).timeout(90000).get();

            assert doc != null;
            Elements scriptElements = doc.getElementsByTag("script");

            for (Element element :scriptElements ){
                for (DataNode node : element.dataNodes()) {
                    if(node.toString().contains("https://b.zmtcdn.com/data/pictures")){
                        String data = node.getWholeData();
                        String[] split = data.split("\n");

                        for(String i :split){
                            if(i.contains("https://b.zmtcdn.com/data/pictures")) {
                                String[] JsonData = i.split("\"");
                                for(int j=0; j<JsonData.length;j++){
                                    if(JsonData[j].contains("https://b.zmtcdn.com/data/pictures")){
                                        zomatoWebOrder.setThumbURL(JsonData[j]);
                                        return ;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (HttpStatusException e){
            if(e.getStatusCode()==404){
                System.out.println("Error 404: Result not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public void Locality(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void LocalityVerbose(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void Longitude(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void Latitude(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void Cuisines(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void AverageCost(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void Currency(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void HasTableBooking(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void DeliveringNow(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void PriceRange(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void AggregateRating(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void RatingColor(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void RatingText(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void Votes(String url){
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).timeout(90000).get();
//
//            assert doc != null;
//            Elements scriptElements = doc.getElementsByTag("script");
//
//            for (Element element :scriptElements ){
//                for (DataNode node : element.dataNodes()) {
//                    if(node.toString().contains("res_id")){
//                        String data = node.getWholeData();
//                        String[] split = data.split("\n");
//                        for(String i :split){
//                            if(i.contains("res_id")) {
//                                String[] JsonData = i.split(":");
//                                for(int j=0; j<JsonData.length;j++){
//                                    if(JsonData[j].contains("res_id")){
//                                        String[] res_idWhole = JsonData[j+1].split(",");
//                                        this.restaurantID = res_idWhole[0];
//                                        return ;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch (HttpStatusException e){
//            if(e.getStatusCode()==404){
//                System.out.println("Error 404: Result not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
