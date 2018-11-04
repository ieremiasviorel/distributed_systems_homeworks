import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TaxValueServiceService } from './tax-value-service.service';
import { ResalePriceServiceService } from './resale-price-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'app';

  taxValueCalculatorForm: FormGroup;
  resalePriceCalculatorForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private taxValueService: TaxValueServiceService,
    private resalePriceService: ResalePriceServiceService
  ) { }

  ngOnInit() {
    this.initTaxCalculatorForm();
    this.initResalePriceCalculatorForm();
  }

  private initTaxCalculatorForm() {
    this.taxValueCalculatorForm = this.formBuilder.group({
      engineSize: [{ value: '', disabled: false }, [Validators.required, Validators.pattern('[0-9]*')]],
      taxValue: [{ value: '', disabled: true }]
    })
  };

  private initResalePriceCalculatorForm() {
    this.resalePriceCalculatorForm = this.formBuilder.group({
      purchasePrice: [{ value: '', disabled: false }, [Validators.required, Validators.pattern('[0-9]*.?[0-9]*')]],
      productionYear: [{ value: '', disabled: false }, [Validators.required, Validators.pattern('[0-9]*')]],
      resalePrice: [{ value: '', disabled: true }]
    })
  }

  computeTaxValue(): void {
    let engineSize = this.taxValueCalculatorForm.value['engineSize'];
    this.taxValueService.computeTaxValue(engineSize)
      .subscribe(
        (taxValue: number) => { this.taxValueCalculatorForm.get('taxValue').patchValue(new Number(taxValue).toFixed(2)); }
      )
  }

  computeResalePrice(): void {
    let purchasePrice = this.resalePriceCalculatorForm.value['purchasePrice'];
    let productionYear = this.resalePriceCalculatorForm.value['productionYear'];
    this.resalePriceService.computeResalePrice(purchasePrice, productionYear)
      .subscribe(
        (resalePrice: number) => { this.resalePriceCalculatorForm.get('resalePrice').patchValue(new Number(resalePrice).toFixed(2)); }
      )
  }
}
