package com.canva.intellij.searchinkibana;

public class SearchInKibanaProdAction extends AbstractSearchInKibanaAction {
  public SearchInKibanaProdAction() {
    super("https://logs.canva-corp.com/_plugin/kibana/app/discover#/?_g=(filters:!(),"
        + "refreshInterval:(pause:!t,value:0),time:(from:now-3d,to:now))&_a=(columns:!"
        + "(_source),filters:!(),index:'910a5380-d73e-11ec-b177-17b5d0565d91',interval:auto,"
        + "query:(language:kuery,query:'%s'),sort:!())");
  }
}
