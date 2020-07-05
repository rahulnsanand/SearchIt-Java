package com.searchit.tfg.UI;

import com.searchit.tfg.UI.utils.ThumbnailRetrieve;
import com.searchit.tfg.UI.SearchElement.RetrieveMapsAPI;
import com.searchit.tfg.UI.SearchElement.SearchData;
import com.searchit.tfg.dataset.retrieve.ZomatoAPISearch;
import com.searchit.tfg.dataset.retrieve.ZomatoWebOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResultsPanel extends JPanel {

    public int darkTheme;
    public String selectedItem;
    public String selectedID;
    private javax.swing.JTextArea addressLabel;
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
    private javax.swing.JLabel hasTableBookingIcon;
    private javax.swing.JLabel hasDeliveryIcon;
    private javax.swing.JLabel isDeliveringIcon;
    private javax.swing.JLabel votesLabel;
    private MainWindow mainWindow;
    private SearchData searchData;
    private ImageIcon mapImage = new ImageIcon();
    private ImageIcon thumbImage = new ImageIcon();
    private ImageIcon tableBookingIcon = new ImageIcon();
    private ImageIcon hasOnlineDeliveryIcon = new ImageIcon();
    private ImageIcon isOnlineDeliveringIcon = new ImageIcon();
    private static String TickIcon = "src\\main\\resources\\tick.png";
    private static String CrossIcon = "src\\main\\resources\\cross.png";

    private static final ZomatoWebOrder zomato = new ZomatoWebOrder();

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

    public ResultsPanel(SearchData searchData, MainWindow mainWindow, int darkTheme){
        this.selectedItem = searchData.getSelectedItem();
        this.selectedID = searchData.getNameIDMap().get(this.selectedItem);
        this.mainWindow = mainWindow;
        this.searchData = searchData;
        this.darkTheme = darkTheme;
        callAPI(this.selectedID);
        initComponents();
    }
    public void themeCheck() {
        if(darkTheme==1){
            setBackground(new java.awt.Color(50, 50, 50, 255));
            addressLabel.setForeground(new java.awt.Color(239, 239, 239));
            aggregateRatingLabel.setForeground(new java.awt.Color(239, 239, 239));
            topPanel.setBackground(new java.awt.Color(41, 41, 41, 255));
            bottomPanel.setBackground(new java.awt.Color(41, 41, 41, 255));
            costForTwoLabel.setForeground(new java.awt.Color(239, 239, 239));
            downloadAsJSONButton.setForeground(new java.awt.Color(41, 41, 41, 255));
            searchPageButton.setForeground(new java.awt.Color(41, 41, 41, 255));
            hasOnlineDeliveryLabel.setForeground(new java.awt.Color(239, 239, 239));
            hasTableBookingLabel.setForeground(new java.awt.Color(239, 239, 239));
            idLabel.setForeground(new java.awt.Color(239, 239, 239));
            isDeliveringNowLabel.setForeground(new java.awt.Color(239, 239, 239));
            madeInIndiaLabel.setForeground(new java.awt.Color(239, 239, 239));
            nameLabel.setForeground(new java.awt.Color(239, 239, 239));
            phoneLabel.setForeground(new java.awt.Color(239, 239, 239));
            ratingTextLabel.setForeground(new java.awt.Color(239, 239, 239));
            searchItLogoLabel.setForeground(new java.awt.Color(239, 239, 239));
            votesLabel.setForeground(new java.awt.Color(239, 239, 239));
        }
        else{
            setBackground(new java.awt.Color(239, 239, 239, 255));
            addressLabel.setForeground(new java.awt.Color(52, 52, 52, 255));
            aggregateRatingLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            topPanel.setBackground(new java.awt.Color(41, 41, 41, 255));
            bottomPanel.setBackground(new java.awt.Color(41, 41, 41, 255));
            costForTwoLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            downloadAsJSONButton.setForeground(new java.awt.Color(41, 41, 41, 255));
            searchPageButton.setForeground(new java.awt.Color(41, 41, 41, 255));
            hasOnlineDeliveryLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            hasTableBookingLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            idLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            isDeliveringNowLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            madeInIndiaLabel.setForeground(new java.awt.Color(239, 239, 239, 255));
            nameLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            phoneLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            ratingTextLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
            searchItLogoLabel.setForeground(new java.awt.Color(239, 239, 239, 255));
            votesLabel.setForeground(new java.awt.Color(50, 50, 50, 255));
        }
    }
    private void backToSearchPage(java.awt.event.ActionEvent evt) {
        SearchPanel searchPanel= new SearchPanel(searchData,mainWindow);
        mainWindow.switchToSearchPanel(searchPanel);
    }

    public void initComponents() {

        topPanel = new javax.swing.JPanel();
        searchItLogoLabel = new javax.swing.JLabel();
        downloadAsJSONButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        madeInIndiaLabel = new javax.swing.JLabel();
        searchPageButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameLabel.setText(zomato.getRestaurantName());
        idLabel = new javax.swing.JLabel();
        idLabel.setText("ID: "+zomato.getRestaurantID());
        addressLabel = new javax.swing.JTextArea();
        addressLabel.setText(formatAddress(zomato.getAddress()));
        costForTwoLabel = new javax.swing.JLabel();
        costForTwoLabel.setText("- Cost for two: "+zomato.getCurrency()+" "+zomato.getAverageCostForTwo());

        hasTableBookingIcon = new javax.swing.JLabel();
        hasDeliveryIcon = new javax.swing.JLabel();
        isDeliveringIcon = new javax.swing.JLabel();
        isDeliveringNowLabel = new javax.swing.JLabel();
        hasTableBookingLabel = new javax.swing.JLabel();
        hasOnlineDeliveryLabel = new javax.swing.JLabel();

        hasTableBookingLabel.setText(getTable(zomato.getHasTableBooking()));
        hasOnlineDeliveryLabel.setText(getDelivery(zomato.getHasOnlineDelivery()));
        isDeliveringNowLabel.setText(getCurrentDelivery(zomato.getIsDeliveringNow()));

        mapsImageLabel = new javax.swing.JLabel();
        mapImage = RetrieveMapsAPI.getMapImage(zomato.getLatitude(),zomato.getLongitude(),690,130);
        Image scaledMapInstance = mapImage.getImage()
                .getScaledInstance(690,130, Image.SCALE_SMOOTH);
        ImageIcon scaledMapIcon = new ImageIcon(scaledMapInstance);
        mapsImageLabel.setIcon(scaledMapIcon);

        thumbImageLabel = new javax.swing.JLabel();
        thumbImage = ThumbnailRetrieve.getThumbImage(zomato.getThumbURL());
        Image scaledThumbInstance = thumbImage.getImage()
                .getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon scaledThumbIcon = new ImageIcon(scaledThumbInstance);
        thumbImageLabel.setIcon(scaledThumbIcon);

        aggregateRatingLabel = new javax.swing.JLabel();
        aggregateRatingLabel.setText("Aggregate Rating: "+zomato.getAggregateRating());
        ratingTextLabel = new javax.swing.JLabel();
        ratingTextLabel.setText("Rating Text: "+zomato.getRatingText());
        votesLabel = new javax.swing.JLabel();
        votesLabel.setText("No. of Votes: "+zomato.getVotes());

        phoneLabel = new javax.swing.JLabel();
        phoneLabel.setText("Phone: "+zomato.getPhoneNumber());
        themeCheck();

        topPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        bottomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bottomPanel.setMaximumSize(new java.awt.Dimension(32767, 38));
        bottomPanel.setMinimumSize(new java.awt.Dimension(100, 38));


        searchPageButton.setFont(new java.awt.Font("Consolas", Font.BOLD, 12)); // NOI18N
        searchPageButton.setText("SearchIt Another Restaurant");
        searchPageButton.addActionListener(this::backToSearchPage);
        downloadAsJSONButton.setFont(new java.awt.Font("Consolas", Font.BOLD, 12)); // NOI18N
        downloadAsJSONButton.setText("Download as Json");
        downloadAsJSONButton.addActionListener(this::downloadAsJSON);

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

        thumbImageLabel.setAlignmentY(0.0F);
        thumbImageLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#"+zomato.getRatingColor())));
        thumbImageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mapsImageLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 41, 41)));
        mapsImageLabel.setMaximumSize(new java.awt.Dimension(2, 400));
        mapsImageLabel.setMinimumSize(new java.awt.Dimension(2, 100));
        mapsImageLabel.setPreferredSize(new java.awt.Dimension(2, 200));

        madeInIndiaLabel.setFont(new java.awt.Font("Consolas", 2, 12)); // NOI18N
        madeInIndiaLabel.setText("Made In India By TheFlopGuy");
        searchItLogoLabel.setFont(new java.awt.Font("Consolas", 2, 48)); // NOI18N
        searchItLogoLabel.setText("SᴇᴀʀᴄʜIᴛ");
        thumbImageLabel.setFont(new java.awt.Font("Consolas", 3, 36)); // NOI18N
        nameLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        idLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addressLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        aggregateRatingLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        costForTwoLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        ratingTextLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        votesLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        hasTableBookingLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        hasOnlineDeliveryLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        isDeliveringNowLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        phoneLabel.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        hasTableBookingIcon.setBorder(new javax.swing.border.MatteBorder(null));
        hasTableBookingIcon.setMaximumSize(new java.awt.Dimension(20, 20));
        hasTableBookingIcon.setMinimumSize(new java.awt.Dimension(20, 20));
        hasTableBookingIcon.setPreferredSize(new java.awt.Dimension(20, 20));

        hasDeliveryIcon.setBorder(new javax.swing.border.MatteBorder(null));
        hasDeliveryIcon.setMaximumSize(new java.awt.Dimension(20, 20));
        hasDeliveryIcon.setMinimumSize(new java.awt.Dimension(20, 20));
        hasDeliveryIcon.setPreferredSize(new java.awt.Dimension(20, 20));

        isDeliveringIcon.setBorder(new javax.swing.border.MatteBorder(null));
        isDeliveringIcon.setMaximumSize(new java.awt.Dimension(20, 20));
        isDeliveringIcon.setMinimumSize(new java.awt.Dimension(20, 20));
        isDeliveringIcon.setPreferredSize(new java.awt.Dimension(20, 20));

        addressLabel.setBackground(new java.awt.Color(50, 50, 50));
        addressLabel.setColumns(20);
        addressLabel.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        addressLabel.setRows(5);
        addressLabel.setBorder(null);
        addressLabel.setEnabled(false);
//        jScrollPane1.setViewportView(addressLabel);
//        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(mapsImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(thumbImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(40, 40, 40)
                                                                .addComponent(hasTableBookingIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hasDeliveryIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(166, 166, 166)
                                                                .addComponent(isDeliveringIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(52, 52, 52))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(hasTableBookingLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                                                .addComponent(hasOnlineDeliveryLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                                                .addComponent(isDeliveringNowLabel))
                                                        .addComponent(addressLabel)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(phoneLabel)
                                                                        .addComponent(ratingTextLabel)
                                                                        .addComponent(aggregateRatingLabel)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(idLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(costForTwoLabel))
                                                                        .addComponent(votesLabel))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(thumbImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(idLabel)
                                                        .addComponent(costForTwoLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(phoneLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(votesLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(aggregateRatingLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ratingTextLabel)
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(hasTableBookingLabel)
                                                                        .addComponent(hasOnlineDeliveryLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(hasDeliveryIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(hasTableBookingIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(isDeliveringNowLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(isDeliveringIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mapsImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private String getTable(String hasTableBooking) {
        if(hasTableBooking.equals("0")){
            tableBookingIcon = new ImageIcon(CrossIcon);
            Image scaledTableInstance = tableBookingIcon.getImage()
                    .getScaledInstance(20,20, Image.SCALE_SMOOTH);
            ImageIcon scaledTableIcon = new ImageIcon(scaledTableInstance);
            hasTableBookingIcon.setIcon(scaledTableIcon);
            return "No Table Booking";
        }
        else {
            tableBookingIcon = new ImageIcon(TickIcon);
            Image scaledTableInstance = tableBookingIcon.getImage()
                    .getScaledInstance(20,20, Image.SCALE_SMOOTH);
            ImageIcon scaledTableIcon = new ImageIcon(scaledTableInstance);
            hasTableBookingIcon.setIcon(scaledTableIcon);
            return "Has Table Booking";
        }
    }

    private String getDelivery(String hasDelivery) {
        if(hasDelivery.equals("0")){
            hasOnlineDeliveryIcon = new ImageIcon(CrossIcon);
            Image scaledHasDeliveryInstance = hasOnlineDeliveryIcon.getImage()
                    .getScaledInstance(20,20, Image.SCALE_SMOOTH);
            ImageIcon scaledHasDeliveryIcon = new ImageIcon(scaledHasDeliveryInstance);
            hasDeliveryIcon.setIcon(scaledHasDeliveryIcon);
            return "No Online Delivery";
        }
        else {
            hasOnlineDeliveryIcon = new ImageIcon(TickIcon);
            Image scaledHasDeliveryInstance = hasOnlineDeliveryIcon.getImage()
                    .getScaledInstance(20,20, Image.SCALE_SMOOTH);
            ImageIcon scaledHasDeliveryIcon = new ImageIcon(scaledHasDeliveryInstance);
            hasDeliveryIcon.setIcon(scaledHasDeliveryIcon);
            return "Has Online Delivery";
        }
    }

    private String getCurrentDelivery(String isDelivering) {
        if(isDelivering.equals("0")){
            isOnlineDeliveringIcon = new ImageIcon(CrossIcon);
            Image scaledIsDeliveryInstance = isOnlineDeliveringIcon.getImage()
                    .getScaledInstance(20,20, Image.SCALE_SMOOTH);
            ImageIcon scaledIsDeliveryIcon = new ImageIcon(scaledIsDeliveryInstance);
            isDeliveringIcon.setIcon(scaledIsDeliveryIcon);
            return "Not Delivering Now";
        }
        else{
            isOnlineDeliveringIcon = new ImageIcon(TickIcon);
            Image scaledIsDeliveryInstance = isOnlineDeliveringIcon.getImage()
                    .getScaledInstance(20,20, Image.SCALE_SMOOTH);
            ImageIcon scaledIsDeliveryIcon = new ImageIcon(scaledIsDeliveryInstance);
            isDeliveringIcon.setIcon(scaledIsDeliveryIcon);
            return "Is Delivering Now";
        }

    }

    public static String formatAddress(String s) {
        String outAddress = "";
        int counter = 0;
        for (String val: s.split(" ")){
            if(counter<4){
                outAddress += val;
                counter++;
            }
            else{
                counter=0;
                outAddress += "\n";
            }
        }
        return outAddress;
    }

    private void downloadAsJSON(ActionEvent actionEvent) {
    }
}
