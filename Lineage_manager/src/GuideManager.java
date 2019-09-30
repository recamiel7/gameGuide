//////////////////////////////////////////////////////////////////////////////////////////////////
//																								//
//										데이터 관리용 클래스											//
//																								//
//////////////////////////////////////////////////////////////////////////////////////////////////


import java.io.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

class GuideManager {
	static Scanner input = new Scanner(System.in);
	private static File recordDataFile = new File("recordData.dat");
	private static File tipDataFile = new File("tipData.dat");
	HashSet<CharacterRecord> charaterData = new LinkedHashSet<CharacterRecord>();
	String[] tipStr = new String[3];
	CharacterRecord currentRecord = null;
	CharacterRecord prevRecord;
	
	private static GuideManager inst =null; //인스턴스 생성 확인용 참조변수
	
	public static GuideManager createManagerInst(){//인스턴스 생성 제한용
		if(inst == null){ //인스턴스가 생성되지 않았을 경우 인스턴스 생성
			inst = new GuideManager();
		}
		
		return inst; //생성된 참조변수 반환
	}
	
	private GuideManager(){cReadData();tReadData();}
	
	void inputRecord(String level, String power, String pRank, String hRank, String aRank){
		charaterData.add(new CharacterRecord(level, power, pRank, hRank, aRank));
	}
	
	String deleteData(String code){ //데이터 삭제 메소드
		
		Iterator<CharacterRecord> itrdel = charaterData.iterator(); 
		while(itrdel.hasNext()){
			CharacterRecord deldata = itrdel.next();//데이터 비교용 
			String cCode = deldata.cal.getTimeInMillis()+"";
			if(cCode.compareTo(code) == 0){//같은 코드인 경우
				itrdel.remove();//데이터 삭제
				return "삭제 완료\n";
			}
		}
	
		return null;
	}
	
	String search(String code){//입력된 코드로 저장된 데이터 유무 확인용
		
		Iterator<CharacterRecord> itr = charaterData.iterator();
		
		while(itr.hasNext()){
			CharacterRecord sc = itr.next(); //데이터 비교용
			String cCode = sc.cal.getTimeInMillis()+"";
			if(cCode.compareTo(code) == 0) //같은 
				return sc.toString(); //
		}
		
		return null; //검색된 데이터가 없을 경우 false 반환
	}
	
	void getCrRecord(){ //가장 마지막에 저장한 기록과 그전 기록 얻기위한 메소드
		Iterator<CharacterRecord> itr = charaterData.iterator();
		
		while(itr.hasNext()){
			prevRecord = currentRecord;
			currentRecord = itr.next(); 
		}	
	}
	
	String changeDate(String code, String level, String power, String pRank, //데이터 수정 
			String hRank, String aRank){
		Iterator<CharacterRecord> itrdel = charaterData.iterator();
		
		if(level == null&&power == null&&pRank==null&&hRank==null&&aRank==null) //입력된 값이 없을 경우 null값 반환
			return null;
		
		while(itrdel.hasNext()){
			CharacterRecord cgdata = itrdel.next();//데이터 비교용 
			String cCode = cgdata.cal.getTimeInMillis()+"";
			if(cCode.compareTo(code) == 0){//같은 코드인 경우
				
				if(level != null)
					cgdata.level = level;
				if(power != null)
					cgdata.power = power;
				if(pRank != null)
					cgdata.powerRank = pRank;
				if(hRank != null)
					cgdata.honorRank = hRank;
				if(aRank != null)
					cgdata.achievementRank = aRank;
							
				return "변경 완료\n";
			}
		}
	
		return null;
	}

	String getRecordAllData(){ //성장기록 데이터 전체 출력
		Iterator<CharacterRecord> getitr = charaterData.iterator();
		String getData = null;
		
		while(getitr.hasNext()){
			CharacterRecord sd = getitr.next(); //데이터 저장
			
			if(getData != null)
				getData = getData + sd.toString(); //데이터 출력
			else 
				getData = sd.toString();
		}
		
		return getData;
	}
	
	String getCodeAllData(){ //성장기록 데이터 전체 출력(코드출력 추가)
		Iterator<CharacterRecord> getitr = charaterData.iterator();
		String getData = null;
		
		while(getitr.hasNext()){
			CharacterRecord sd = getitr.next(); //데이터 저장
			String code = "*코드 : "+sd.cal.getTimeInMillis()+"*\n\n";
			
			if(getData != null)
				getData = getData + sd.toString()+code; //데이터 출력
			else 
				getData = sd.toString()+code;
		}
		
		return getData;
	}
	
	void cStoreData(){ //recordDataFile에 데이터를 저장할 메소드
		try {
			FileOutputStream rData = new FileOutputStream(recordDataFile);
			ObjectOutputStream rOut = new ObjectOutputStream(rData);
			
			Iterator<CharacterRecord> storeItr = charaterData.iterator(); 
			
			while(storeItr.hasNext()){ // phonedata(HashSet)에 저장된 데이터가 있을 경우
				rOut.writeObject(storeItr.next()); //recordDataFile에 저장
			}
			
			rOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void tStoreDate(){ //tipDataFile에 데이터를 저장할 메소드
		try {
			FileOutputStream tData = new FileOutputStream(tipDataFile);
			ObjectOutputStream tOut = new ObjectOutputStream(tData);

			
			for(int i =0; i<tipStr.length; i++){
				tOut.writeObject(tipStr[i]); //tipDataFile에 저장
			}
			
			tOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void cReadData(){ //recordDataFile에 저장된 데이터를 읽어올 메소드
		
		if(recordDataFile.exists()==false) //recordDataFile이 없을 경우
			return;
		
		try {
			FileInputStream rData = new FileInputStream(recordDataFile);
			ObjectInputStream rIn = new ObjectInputStream(rData);
				while(true){
				
				CharacterRecord readRecordData = (CharacterRecord)rIn.readObject();
				
				if(readRecordData == null){ //읽어올값이 더이상 없을 경우
					rIn.close();
					break;
				}
				
				charaterData.add(readRecordData); //읽어온 값을 phonedata(HashSet)에 저장
				
				}
		} catch (ClassNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}
	}
	
	void tReadData(){ //tipDataFile에 저장된 데이터를 읽어올 메소드
		
		if(tipDataFile.exists()==false) //tipDataFile이 없을 경우
			return;
		
		try {
			FileInputStream tData = new FileInputStream(tipDataFile);
			ObjectInputStream tIn = new ObjectInputStream(tData);
				for(int i = 0; i<tipStr.length; i++){
				
					String readTipData = (String)tIn.readObject();
				
					if(readTipData == null){ //읽어올값이 더이상 없을 경우
						tIn.close();
						break;
					}
				
					tipStr[i] = readTipData; // 스트링배열에 읽어온 값 저장
				
				
				}
		} catch (ClassNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}
	}
	
}

class CharacterRecord implements Serializable { //캐릭터기록

	String level; 
	String power; 
	String powerRank; 
	String honorRank; 
	String achievementRank; 
	
	Calendar cal;
	String date;
	
	public int hashCode(){
		return (int)(cal.getTimeInMillis()/1000); 
	}
	
	public boolean equals(Object obj){
		CharacterRecord ps = (CharacterRecord)obj; 
		if(ps.cal.getTimeInMillis()==cal.getTimeInMillis()) 
			return true;
		else  //
			return false;
	}
	
	public CharacterRecord(String level, String power, String pRank, 
							String hRank, String aRank){ //생성자
		this.level = level;
		this.power = power;
		this.powerRank = pRank;
		this.honorRank = hRank;
		this.achievementRank = aRank;
		cal = Calendar.getInstance();
		date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return date+"\n"+"레벨:"+level+" 전투력:"+power +" 전투력랭킹:"+powerRank + 
				" 명성랭킹:"+honorRank+ " 업적랭킹:"+achievementRank+"\n";
	}
}