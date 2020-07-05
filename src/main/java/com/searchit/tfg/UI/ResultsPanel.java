package com.searchit.tfg.UI;

import com.searchit.tfg.UI.SearchElement.SearchData;
import com.searchit.tfg.dataset.retrieve.ZomatoAPISearch;
import com.searchit.tfg.dataset.retrieve.ZomatoWebOrder;
import com.searchit.tfg.floptrie.GetDataPOJO;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {


    public boolean isDarkTheme() {
        return darkTheme;
    }

    public void setDarkTheme(boolean darkTheme) {
        this.darkTheme = darkTheme;
    }

    public boolean darkTheme;
    public String selectedItem;
    public String selectedID;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel aggregateRatingLabel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel costForTwoLabel;
    private javax.swing.JButton downloadAsJSONButton;
    private javax.swing.JLabel hasOnlineDeliveryLabel;
    private javax.swing.JLabel hasTableBookingLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel isDeliveringNowLabel;
    private javax.swing.JLabel madeInIndiaLabel;
    private javax.swing.JLabel mapsImageLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel ratingTextLabel;
    private javax.swing.JLabel searchItLogoLabel;
    private javax.swing.JButton searchPageButton;
    private javax.swing.JLabel thumbImageLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel votesLabel;
    private MainWindow mainWindow;
    private SearchData searchData;
    private static final ZomatoWebOrder zomato = new ZomatoWebOrder();

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public static void callAPI(String res_id){
        ZomatoAPISearch zomatoAPISearch = new ZomatoAPISearch();
        int status = zomatoAPISearch.getApiDetails(zomato,res_id);
        getResponse(status);
    }
    private static void getDetails() {
        System.out.println(zomato.toString());

        if(zomato.getRetryNo()>0){
            System.out.println(zomato.getRetryNo());
        }
    }
    public static void getResponse(int statusID){

        if(statusID == 1){
            getDetails();
        }
        else if (statusID == -1){
            System.out.println("This restaurant doesn't exit anymore");
        }
        else if(statusID == 404){
            System.out.println("Error "+statusID+": Couldn't get the details of this restaurant.");
        }
        else if(statusID ==101){
            System.out.println("Couldn't connect to the website. Check internet speed.");
        }
        else if(statusID == 102){
            System.out.println("IOException occured");
        }
        else if(statusID ==103){
            System.out.println("Couldn't connect to the website. Check internet connection");
        }
        else if(statusID ==104){
            System.out.println("API Limit exceeded!");
        }
        else if(statusID ==105) {
            System.out.println("Null Value Of Restaurant ID Passed!");
        }
    }

    public ResultsPanel(SearchData searchData, MainWindow mainWindow){
        this.selectedItem = searchData.getSelectedItem();
        this.selectedID = searchData.getNameIDMap().get(this.selectedItem);
        this.mainWindow = mainWindow;
        this.searchData = searchData;
        callAPI(this.selectedID);
        initComponents(mainWindow);
    }

//    public static void resultPanel(){
//
////        try{
//////            SFProRegular = Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation);
////            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//////            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation));
////
////        }
////        catch(IOException | FontFormatException e){
////
////        }
//
//    }

    private void backToSearchPage(java.awt.event.ActionEvent evt) {
        SearchPanel searchPanel= new SearchPanel(searchData,mainWindow);
        mainWindow.switchToSearchPanel(searchPanel);
    }

    public void initComponents(MainWindow mainWindow) {

        topPanel = new javax.swing.JPanel();
        searchItLogoLabel = new javax.swing.JLabel();
        searchItLogoLabel.setForeground(new java.awt.Color(239, 239, 239));
        downloadAsJSONButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        madeInIndiaLabel = new javax.swing.JLabel();
        madeInIndiaLabel.setForeground(new java.awt.Color(239, 239, 239));
        searchPageButton = new javax.swing.JButton();
        thumbImageLabel = new javax.swing.JLabel();
        thumbImageLabel.setForeground(new java.awt.Color(239, 239, 239));
        nameLabel = new javax.swing.JLabel();
        nameLabel.setText(zomato.getRestaurantName());
        nameLabel.setForeground(new java.awt.Color(239, 239, 239));
        idLabel = new javax.swing.JLabel();
        idLabel.setText(zomato.getRestaurantID());
        idLabel.setForeground(new java.awt.Color(239, 239, 239));
        addressLabel = new javax.swing.JLabel();
        addressLabel.setText(zomato.getAddress());
        addressLabel.setForeground(new java.awt.Color(239, 239, 239));
        costForTwoLabel = new javax.swing.JLabel();
        costForTwoLabel.setText(zomato.getAverageCostForTwo());
        costForTwoLabel.setForeground(new java.awt.Color(239, 239, 239));

        mapsImageLabel = new javax.swing.JLabel();
        //mapsImageLabel.setText(zomato.getRestaurantName());
        mapsImageLabel.setForeground(new java.awt.Color(239, 239, 239));

        aggregateRatingLabel = new javax.swing.JLabel();
        aggregateRatingLabel.setText(zomato.getAggregateRating());
        aggregateRatingLabel.setForeground(new java.awt.Color(239, 239, 239));
        ratingTextLabel = new javax.swing.JLabel();
        ratingTextLabel.setText(zomato.getRatingText());
        ratingTextLabel.setForeground(new java.awt.Color(239, 239, 239));
        votesLabel = new javax.swing.JLabel();
        votesLabel.setText(zomato.getVotes());
        votesLabel.setForeground(new java.awt.Color(239, 239, 239));

        hasTableBookingLabel = new javax.swing.JLabel();
        hasTableBookingLabel.setText(zomato.getHasTableBooking());
        hasTableBookingLabel.setForeground(new java.awt.Color(239, 239, 239));
        hasOnlineDeliveryLabel = new javax.swing.JLabel();
        hasOnlineDeliveryLabel.setText(zomato.getHasOnlineDelivery());
        hasOnlineDeliveryLabel.setForeground(new java.awt.Color(239, 239, 239));
        isDeliveringNowLabel = new javax.swing.JLabel();
        isDeliveringNowLabel.setText(zomato.getIsDeliveringNow());
        isDeliveringNowLabel.setForeground(new java.awt.Color(239, 239, 239));
        phoneLabel = new javax.swing.JLabel();
        phoneLabel.setText(zomato.getPhoneNumber());
        phoneLabel.setForeground(new java.awt.Color(239, 239, 239));

        setBackground(new java.awt.Color(50, 50, 50));

        topPanel.setBackground(new java.awt.Color(41, 41, 41));
        topPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchItLogoLabel.setFont(new java.awt.Font("Consolas", 2, 48)); // NOI18N
        searchItLogoLabel.setForeground(new java.awt.Color(239, 239, 239));
        searchItLogoLabel.setText("SᴇᴀʀᴄʜIᴛ");

        downloadAsJSONButton.setFont(new java.awt.Font("Consolas", Font.BOLD, 12)); // NOI18N
        downloadAsJSONButton.setText("Download as Json");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
                topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchItLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(downloadAsJSONButton)
                                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
                topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchItLogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(downloadAsJSONButton)))
        );

        bottomPanel.setBackground(new java.awt.Color(41, 41, 41));
        bottomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bottomPanel.setMaximumSize(new java.awt.Dimension(32767, 38));
        bottomPanel.setMinimumSize(new java.awt.Dimension(100, 38));

        madeInIndiaLabel.setFont(new java.awt.Font("Consolas", 2, 12)); // NOI18N
        madeInIndiaLabel.setText("Made In India By TheFlopGuy");

        searchPageButton.setFont(new java.awt.Font("Consolas", Font.BOLD, 12)); // NOI18N
        searchPageButton.setText("SearchIt Another Restaurant");
        searchPageButton.addActionListener(this::backToSearchPage);

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
                bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchPageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(madeInIndiaLabel)
                                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
                bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchPageButton)
                                        .addComponent(madeInIndiaLabel))
                                .addContainerGap())
        );

        thumbImageLabel.setFont(new java.awt.Font("Consolas", 3, 36)); // NOI18N
        thumbImageLabel.setAlignmentY(0.0F);
        thumbImageLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 41, 41)));
        thumbImageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        nameLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N

        idLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        addressLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        costForTwoLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        mapsImageLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 41, 41)));
        mapsImageLabel.setMaximumSize(new java.awt.Dimension(2, 400));
        mapsImageLabel.setMinimumSize(new java.awt.Dimension(2, 100));
        mapsImageLabel.setPreferredSize(new java.awt.Dimension(2, 200));

        aggregateRatingLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        ratingTextLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        votesLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        hasTableBookingLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        hasOnlineDeliveryLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        isDeliveringNowLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N

        phoneLabel.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(thumbImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                                                .addGap(49, 49, 49))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(hasTableBookingLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hasOnlineDeliveryLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(isDeliveringNowLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(idLabel)
                                                                        .addComponent(costForTwoLabel)
                                                                        .addComponent(phoneLabel)
                                                                        .addComponent(votesLabel)
                                                                        .addComponent(aggregateRatingLabel)
                                                                        .addComponent(ratingTextLabel))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addComponent(mapsImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(idLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addressLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(phoneLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(costForTwoLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(votesLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(aggregateRatingLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ratingTextLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(hasTableBookingLabel)
                                                        .addComponent(hasOnlineDeliveryLabel)
                                                        .addComponent(isDeliveringNowLabel)))
                                        .addComponent(thumbImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(mapsImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }



}
