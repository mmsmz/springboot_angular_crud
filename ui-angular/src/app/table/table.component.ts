import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup,FormControl,Validators} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import  *  as  data  from  '../../assets/mock/tableData.json';
import { CommonService } from '../service/common.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  // dyanamicTable: any = (data as any).default;

  dyanamicTable: any [];
  issuccess:boolean = true;
  success:boolean = false;
  adForm : FormGroup;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private formBuilder:FormBuilder,
    private commonService: CommonService
  ) { }

  ngOnInit(): void {
    this.Inziling();
    this.getData();
  }

  getData(){
    this.commonService.getTableData().subscribe(res=>{
      this.dyanamicTable = res.data;
    })
  }

  Inziling(){
    this.adForm =  this.formBuilder.group({
      adId : new FormControl('',Validators.required),
      adName : new FormControl('', Validators.required),
      adDescription :  new FormControl('',Validators.required),
      Type :  new FormControl('', Validators.required),
      Email : new FormControl('', Validators.required),
      startDate :  new FormControl('',Validators.required),
      EndDate :  new FormControl('', Validators.required)
    });
  }

  userEdit(dyTable) {
    this.issuccess = false;
    this.success = true;

    this.adForm.controls['adId'].setValue(dyTable.advertisingId);
    this.adForm.controls['adName'].setValue(dyTable.vacancyName);
    this.adForm.controls['adDescription'].setValue(dyTable.vacancyDescription);
    this.adForm.controls['Type'].setValue(dyTable.vacancyType);
    this.adForm.controls['Email'].setValue(dyTable.email);
  }

  Cancel(){
    this.success = false;
    this.issuccess = true;  
  }

  remove(advId){
    this.commonService.deleteRecord(advId).subscribe(res=>{
      // if(res.data == "Updated Successfullly"){

      // }
      this.getData();
    });
  }

  update(){
    this.success = false;
    this.issuccess = true; 
    
    this.commonService.updateRecord(this.adForm.value).subscribe(res=>{
      // if(res.data == "Updated Successfullly"){

      // }
      this.getData();
    })
  }

}
