package uk.nhs.nhsbsa.ccchs.helpers;

import java.util.HashMap;

public class JsonImportData
{
	private static HashMap<String, String> hmap1;
	private static HashMap<String, String> hmap2;
	private static HashMap<String, String> hmap3;

	public JsonImportData()
	{
		hmap1 = new HashMap<String, String>();
		hmap2 = new HashMap<String, String>();
		hmap3 = new HashMap<String, String>();
	}

	public HashMap<String, String> mdtMultiRbdaExtract()
	{
		hmap1.put("SELECT subm_id FROM returned_item WHERE part_month = '201507' AND pf_id=900000625684 AND i_id=4;",
				"1001");
		hmap1.put("SELECT subm_id FROM returned_item WHERE part_month = '201507' AND pf_id=900000625699 AND i_id=3;",
				"1002");

		return hmap1;
	}

	public HashMap<String, String> mdtIntegrationTestValid()
	{
		hmap2.put(
				"SELECT account_type FROM returned_item WHERE part_month = '201507' AND subm_id=1001 AND pf_id=900000625684 AND i_id=2;",
				"EPHM");
		hmap2.put(
				"SELECT account_type FROM returned_item WHERE part_month = '201507' AND subm_id=2001 AND pf_id=900000625727 AND i_id=2;",
				"EACN");
		hmap2.put(
				"SELECT pfea_charge_status FROM returned_item WHERE part_month = '201507' AND subm_id=1003 AND pf_id=900000625713 AND i_id=3;",
				"E");
		hmap2.put(
				"SELECT pfea_charge_status FROM returned_item WHERE part_month = '201507' AND subm_id=1001 AND pf_id=900000625684 AND i_id=2;",
				"C");
		hmap2.put(
				"SELECT pfea_charge_status FROM returned_item WHERE part_month = '201507' AND subm_id=1002 AND pf_id=900000625699 AND i_id=2;",
				"O");
		hmap2.put("SELECT part_month FROM returned_item WHERE pf_id=900000625723 AND i_id=2;", "201507");
		hmap2.put("SELECT subm_id FROM returned_item WHERE part_month = '201507' AND pf_id=900000625684 AND i_id=2;",
				"1001");
		hmap2.put("SELECT subm_id FROM returned_item WHERE part_month = '201507' AND pf_id=900000625727 AND i_id=4;",
				"2001");
		hmap2.put(
				"SELECT pf_id FROM returned_item WHERE etp_payload_msg_uuid='41174A8D-9AA8-A1BA-B744-86A121E892BB' AND pfea_reason_code='RB6';",
				"900000625730");
		hmap2.put(
				"SELECT i_id FROM returned_item WHERE etp_payload_msg_uuid='26EA58E8-6DB3-2891-D2CE-2208BC1126C5' AND pfea_reason_code='DA1';",
				"2");
		hmap2.put("SELECT disp_code FROM returned_item WHERE subm_id=1003 AND pfea_exempt_cat='B';", "FA053");
		hmap2.put("SELECT presc_code FROM returned_item WHERE pf_id=900000625723 AND i_id=2;", "920095");
		hmap2.put("SELECT presc_code FROM returned_item WHERE pf_id=900000625727AND i_id=3;", "666748");
		hmap2.put("SELECT presc_name FROM returned_item WHERE pf_id=900000625710 AND i_id=1;", "GAYNOR ES");
		hmap2.put("SELECT presc_type FROM returned_item WHERE pf_id=900000625699AND i_id=2;", "RD");
		hmap2.put("SELECT pfea_exempt_cat FROM returned_item WHERE pf_id=900000625723 AND i_id=2;", "F");
		hmap2.put("SELECT pat_nhs_num FROM returned_item WHERE pf_id=900000625723 AND i_id=2;", "2111111005");
		hmap2.put("SELECT pat_surname FROM returned_item WHERE pf_id=900000625710 AND i_id=1;", "CONDER");
		hmap2.put("SELECT pat_postcode FROM returned_item WHERE pf_id=900000625710 AND i_id=1;", "DH1 8QW");
		hmap2.put("SELECT pat_dob FROM returned_item WHERE pf_id=900000625710 AND i_id=1;", "1989-05-20");
		hmap2.put("SELECT presc_addr1 FROM returned_item WHERE pf_id=900000625710 AND i_id=1;",
				"STUDENT SERVICES CENTRE");
		hmap2.put("SELECT presc_addr2 FROM returned_item WHERE pf_id=900000625710 AND i_id=1;", "150 MOUNT PLEASANT");
		hmap2.put("SELECT presc_addr3 FROM returned_item WHERE pf_id=900000625710 AND i_id=1;", "LIVERPOOL");
		hmap2.put("SELECT presc_addr4 FROM returned_item WHERE pf_id=900000625699 AND i_id=3;", "SURREY");
		hmap2.put("SELECT presc_postcode FROM returned_item WHERE pf_id=900000625699AND i_id=3;", "KT17 4BL");
		hmap2.put("SELECT etp_payload_msg_uuid FROM returned_item WHERE pf_id=900000625699 AND i_id=3;",
				"8E8BB136-9243-9023-8BED-6ED3206ADCD4");
		hmap2.put("SELECT pfea_reason_code FROM returned_item WHERE pf_id=900000625725AND i_id=2;", "RB7");
		hmap2.put("SELECT disp_date FROM returned_item WHERE pf_id=900000625712 AND i_id=4;", "2015-07-19");
		hmap2.put(
				"SELECT pfea_endorsement_code FROM ri_presc_element WHERE ri_id IN (SELECT id FROM returned_item WHERE PF_ID=900000625724  AND i_id=1);",
				"ACBS");
		hmap2.put(
				"SELECT prod_name FROM ri_presc_element WHERE ri_id IN (SELECT id FROM returned_item WHERE PF_ID=900000625712  AND i_id=4);",
				"Colecalciferol 400unit / Calcium carbonate 1.5g chewable tablets");
		hmap2.put(
				"SELECT qty FROM ri_presc_element WHERE ri_id IN (SELECT id FROM returned_item WHERE PF_ID=900000625712  AND i_id=4);",
				"12");
		hmap2.put(
				"SELECT elem_id FROM ri_disp_element WHERE ri_id IN (SELECT id FROM returned_item WHERE PF_ID=900000625712  AND i_id=4);",
				"1");
		hmap2.put(
				"SELECT pfea_endorsement_code FROM ri_disp_element WHERE ri_id IN (SELECT id FROM returned_item WHERE PF_ID=900000625712  AND i_id=4);",
				"NB BB");
		hmap2.put(
				"SELECT prod_name FROM ri_disp_element WHERE ri_id IN (SELECT id FROM returned_item WHERE PF_ID=900000625712  AND i_id=4);",
				"Colecalciferol 400unit / Calcium carbonate 1.5g chewable tablets 56 tablet 56.0");
		hmap2.put(
				"SELECT qty FROM ri_disp_element WHERE ri_id IN (SELECT id FROM returned_item WHERE PF_ID=900000625712  AND i_id=4);",
				"12");

		return hmap2;
	}

	public HashMap<String, String> noDataImported()
	{
		hmap3.put("SELECT count(*) from account_lock;", "0");
		hmap3.put("SELECT count(*) from disp_contact;", "0");
		hmap3.put("SELECT count(*) from returned_item;", "0");
		hmap3.put("SELECT count(*) from ri_correction;", "0");
		hmap3.put("SELECT count(*) from ri_disp_element;", "0");
		hmap3.put("SELECT count(*) from ri_presc_element;", "0");
		hmap3.put("SELECT count(*) from workflow;", "0");
		hmap3.put("SELECT count(*) from workflow_event_type;", "5");
		
		return hmap3;
	}
}