//////////////////////////////////////////////////////////////////////////////////////////////////
//																								//
//											메인 GUI												//
//																								//
//////////////////////////////////////////////////////////////////////////////////////////////////


public class GuideGUI extends javax.swing.JFrame {

	static InputCharacter icEdit = new InputCharacter(); 
	static InputGameTip gtEdit = new InputGameTip();
	static GuideManager manager = GuideManager.createManagerInst();
	
	void guideMain() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuideGUI().setVisible(true);
            }
        });
    }
	
    /**
     * Creates new form NewJFrame
     */
    public GuideGUI() {
        initComponents();
    }
                   
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        startTap = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        lineageImage1 = new javax.swing.JLabel();
        characterTap = new javax.swing.JTabbedPane();
        growthRecord = new javax.swing.JPanel();
        level = new javax.swing.JLabel();
        levelText1 = new javax.swing.JTextField();
        levelText2 = new javax.swing.JTextField();
        power = new javax.swing.JLabel();
        powerText1 = new javax.swing.JTextField();
        powerText2 = new javax.swing.JTextField();
        powerRank = new javax.swing.JLabel();
        pRankText1 = new javax.swing.JTextField();
        pRankText2 = new javax.swing.JTextField();
        honorRank = new javax.swing.JLabel();
        hRankText1 = new javax.swing.JTextField();
        hRankText2 = new javax.swing.JTextField();
        achievementRank = new javax.swing.JLabel();
        aRankText1 = new javax.swing.JTextField();
        aRankText2 = new javax.swing.JTextField();
        bottomText = new javax.swing.JLabel();
        present = new javax.swing.JLabel();
        growth = new javax.swing.JLabel();
        growthrecordAll = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recordAllText = new javax.swing.JTextArea();
        gameTipTap = new javax.swing.JTabbedPane();
        diamondTip = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        diaTipText = new javax.swing.JTextArea();
        strengthenTip = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        strTipText = new javax.swing.JTextArea();
        challengeTip = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        challengeTipText = new javax.swing.JTextArea();
        dataEdit = new javax.swing.JPanel();
        lineageImage2 = new javax.swing.JLabel();
        charaterEdit = new javax.swing.JButton();
        gameTipEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(450, 342));
        setResizable(false);
        setTitle("리니지2 레볼루션 가이드");

        startButton.setText("시작하기");
        closeButton.setText("저장 후 종료");
        
        //시작하기 버튼 클릭 시 실행(첫번째 클릭이후 갱신으로 이름 변경)
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRecord();//성장기록 데이터 출력
                if(manager.getRecordAllData() != null){ //저장된 성장기록 전체 출력
                	recordAllText.setText("");
                	recordAllText.append(manager.getRecordAllData());
                }
                showTip(); //저장된 Tip내용 출력
                
                startButton.setText("갱신");
                
            }
        });

        //저장 후 종료 버튼 클릭시 실행
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manager.cStoreData(); //성장기록 저장
                manager.tStoreDate(); //Tip내용 저장
                System.exit(0); //종료
            }
        });

        lineageImage1.setIcon(new javax.swing.ImageIcon("70초기배경.jpg"));

        javax.swing.GroupLayout startTapLayout = new javax.swing.GroupLayout(startTap);
        startTap.setLayout(startTapLayout);
        startTapLayout.setHorizontalGroup(
            startTapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startTapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startButton)
                .addGap(74, 74, 74)
                .addComponent(closeButton)
                .addGap(84, 84, 84))
            .addGroup(startTapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineageImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        startTapLayout.setVerticalGroup(
            startTapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startTapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineageImage1)
                .addGap(18, 18, 18)
                .addGroup(startTapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(closeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("시작하기", startTap);

        growthRecord.setMaximumSize(new java.awt.Dimension(450, 284));

        level.setText("전투력");

        levelText1.setColumns(6);

        levelText2.setColumns(6);

        power.setText("레벨");

        powerText1.setColumns(6);

        powerText2.setColumns(6);

        powerRank.setText("전투력 랭킹");

        pRankText1.setColumns(6);

        pRankText2.setColumns(6);
        pRankText2.setToolTipText("");

        honorRank.setText("명예 랭킹");

        hRankText1.setColumns(6);

        hRankText2.setColumns(6);

        achievementRank.setText("업적 랭킹");

        aRankText1.setColumns(6);

        aRankText2.setColumns(6);

        bottomText.setText("*마지막 저장 대비 성장 표시");

        present.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        present.setText("현재");

        growth.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        growth.setText("성장");

        javax.swing.GroupLayout growthRecordLayout = new javax.swing.GroupLayout(growthRecord);
        growthRecord.setLayout(growthRecordLayout);
        growthRecordLayout.setHorizontalGroup(
            growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(growthRecordLayout.createSequentialGroup()
                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, growthRecordLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottomText))
                    .addGroup(growthRecordLayout.createSequentialGroup()
                        .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(growthRecordLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(present)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE))
                            .addGroup(growthRecordLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(achievementRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(honorRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(powerRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(power, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(levelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(powerText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hRankText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aRankText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pRankText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)))
                        .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(levelText2)
                            .addComponent(powerText2)
                            .addComponent(pRankText2)
                            .addComponent(hRankText2)
                            .addGroup(growthRecordLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(growth))
                            .addComponent(aRankText2))
                        .addGap(61, 61, 61)))
                .addContainerGap())
        );
        growthRecordLayout.setVerticalGroup(
            growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(growthRecordLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(present)
                    .addComponent(growth))
                .addGap(10, 10, 10)
                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(power)
                    .addComponent(levelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level)
                    .addComponent(powerText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(powerText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(powerRank)
                    .addComponent(pRankText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pRankText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(honorRank)
                    .addComponent(hRankText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hRankText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(achievementRank)
                    .addGroup(growthRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(aRankText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(aRankText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(bottomText)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        characterTap.addTab("성장기록", growthRecord);

        recordAllText.setColumns(20);
        recordAllText.setRows(5);
        recordAllText.setEditable(false); // 텍스트 수정 안되게 설정
        jScrollPane2.setViewportView(recordAllText);

        javax.swing.GroupLayout growthrecordAllLayout = new javax.swing.GroupLayout(growthrecordAll);
        growthrecordAll.setLayout(growthrecordAllLayout);
        growthrecordAllLayout.setHorizontalGroup(
            growthrecordAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(growthrecordAllLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
        growthrecordAllLayout.setVerticalGroup(
            growthrecordAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(growthrecordAllLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        characterTap.addTab("성장기록 전체", growthrecordAll);

        jTabbedPane1.addTab("캐릭터", characterTap);

        diaTipText.setColumns(20);
        diaTipText.setRows(5);
        diaTipText.setEditable(false); // 텍스트 수정 안되게 설정
        jScrollPane3.setViewportView(diaTipText);

        javax.swing.GroupLayout diamondTipLayout = new javax.swing.GroupLayout(diamondTip);
        diamondTip.setLayout(diamondTipLayout);
        diamondTipLayout.setHorizontalGroup(
            diamondTipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diamondTipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
        diamondTipLayout.setVerticalGroup(
            diamondTipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diamondTipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        gameTipTap.addTab("다이아 사용 Tip", diamondTip);

        strTipText.setColumns(20);
        strTipText.setRows(5);
        strTipText.setEditable(false); // 텍스트 수정 안되게 설정
        jScrollPane4.setViewportView(strTipText);

        javax.swing.GroupLayout strengthenTipLayout = new javax.swing.GroupLayout(strengthenTip);
        strengthenTip.setLayout(strengthenTipLayout);
        strengthenTipLayout.setHorizontalGroup(
            strengthenTipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(strengthenTipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
        strengthenTipLayout.setVerticalGroup(
            strengthenTipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(strengthenTipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        gameTipTap.addTab("강화 Tip", strengthenTip);

        challengeTipText.setColumns(20);
        challengeTipText.setRows(5);
        challengeTipText.setEditable(false); // 텍스트 수정 안되게 설정
        jScrollPane5.setViewportView(challengeTipText);

        javax.swing.GroupLayout challengeTipLayout = new javax.swing.GroupLayout(challengeTip);
        challengeTip.setLayout(challengeTipLayout);
        challengeTipLayout.setHorizontalGroup(
            challengeTipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(challengeTipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
        challengeTipLayout.setVerticalGroup(
            challengeTipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(challengeTipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        gameTipTap.addTab("결투장 Tip", challengeTip);

        jTabbedPane1.addTab("게임 Tip", gameTipTap);

        lineageImage2.setIcon(new javax.swing.ImageIcon("20리니지추가이미지.jpg")); // NOI18N

        charaterEdit.setText("캐릭터");
        gameTipEdit.setText("게임 Tip");
        
        //캐릭터 버튼 클릭시 실행
        charaterEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	icEdit.inputCharacter(); //성장기록 관리창 활성화
            }
        });

        //게임Tip 버튼 클릭시 실행
        gameTipEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	gtEdit.inputGameTip(); //게임팁 입력창 활성화
            }
        });

        javax.swing.GroupLayout dataEditLayout = new javax.swing.GroupLayout(dataEdit);
        dataEdit.setLayout(dataEditLayout);
        dataEditLayout.setHorizontalGroup(
            dataEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataEditLayout.createSequentialGroup()
                        .addComponent(charaterEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gameTipEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lineageImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataEditLayout.setVerticalGroup(
            dataEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineageImage2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dataEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(charaterEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameTipEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("데이터 추가 및 수정", dataEdit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    void showRecord(){ //GUI창에 성장기록 출력
    	manager.getCrRecord(); //최근 저장된 2개의 데이터 설정
    	if(manager.currentRecord != null){ //현재 정보
    		String level1 = manager.currentRecord.level;
    		String power1 = manager.currentRecord.power;
    		String pRank1 = manager.currentRecord.powerRank;
    		String hRank1 = manager.currentRecord.honorRank;
    		String aRank1 = manager.currentRecord.achievementRank;
    		
    		levelText1.setText(level1);
    		powerText1.setText(power1);
    		pRankText1.setText(pRank1);
    		hRankText1.setText(hRank1);
    		aRankText1.setText(aRank1);
    		if(manager.prevRecord != null){ //현재 정보 전에 저장된 정보
    			String level2 = (Integer.parseInt(level1)-Integer.parseInt(manager.prevRecord.level))+"";
        		String power2 = (Integer.parseInt(power1)-Integer.parseInt(manager.prevRecord.power))+"";
        		String pRank2 = (Integer.parseInt(pRank1)-Integer.parseInt(manager.prevRecord.powerRank))+"";
        		String hRank2 = (Integer.parseInt(hRank1)-Integer.parseInt(manager.prevRecord.honorRank))+"";
        		String aRank2 = (Integer.parseInt(aRank1)-Integer.parseInt(manager.prevRecord.achievementRank))+"";
    			
    			levelText2.setText(level2);
    			powerText2.setText(power2);
    			pRankText2.setText(pRank2);
    			hRankText2.setText(hRank2);
    			aRankText2.setText(aRank2);
    		}
    	}
    	
    }
    
    void showTip(){ //Gui창에 저장된 Tip정보 출력
    	if(manager.tipStr[0] !=null){
    		diaTipText.setText("");
    		diaTipText.append(manager.tipStr[0]);
    	}
    	if(manager.tipStr[1] !=null){
    		strTipText.setText("");
    		strTipText.append(manager.tipStr[1]);
    	}
    	if(manager.tipStr[2] !=null){
    		challengeTipText.setText("");
    		challengeTipText.append(manager.tipStr[2]);
    	}
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JTextField aRankText1;
    private javax.swing.JTextField aRankText2;
    private javax.swing.JLabel achievementRank;
    private javax.swing.JLabel bottomText;
    private javax.swing.JPanel challengeTip;
    private javax.swing.JTextArea challengeTipText;
    private javax.swing.JTabbedPane characterTap;
    private javax.swing.JButton charaterEdit;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel dataEdit;
    private javax.swing.JTextArea diaTipText;
    private javax.swing.JPanel diamondTip;
    private javax.swing.JTextArea recordAllText;
    private javax.swing.JTabbedPane gameTipTap;
    private javax.swing.JButton gameTipEdit;
    private javax.swing.JLabel growth;
    private javax.swing.JPanel growthrecordAll;
    private javax.swing.JPanel growthRecord;
    private javax.swing.JTextField hRankText1;
    private javax.swing.JTextField hRankText2;
    private javax.swing.JLabel honorRank;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel level;
    private javax.swing.JTextField levelText1;
    private javax.swing.JTextField levelText2;
    private javax.swing.JLabel lineageImage1;
    private javax.swing.JLabel lineageImage2;
    private javax.swing.JTextField pRankText1;
    private javax.swing.JTextField pRankText2;
    private javax.swing.JLabel power;
    private javax.swing.JLabel powerRank;
    private javax.swing.JTextField powerText1;
    private javax.swing.JTextField powerText2;
    private javax.swing.JLabel present;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel startTap;
    private javax.swing.JTextArea strTipText;
    private javax.swing.JPanel strengthenTip;
    // End of variables declaration                   
}
