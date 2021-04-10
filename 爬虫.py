import requests
from bs4 import BeautifulSoup
import re
import json
from tqdm import tqdm
import openpyxl

class CoronaVirusSpider(object):
    def __init__(self):
        self.url='https://ncov.dxy.cn/ncovh5/view/pneumonia'

    def get_content_from_url(self,url):
        response = requests.get(url)
        home_page = response.content.decode();
        return  home_page

    def parse_home_page(self,home_page):
        soup = BeautifulSoup(home_page, 'lxml')
        script = soup.find(id='getListByCountryTypeService2true')
        text = script.contents[0]
        json_str = re.findall(r'\[.+\]', text)[0]
        data = json.loads(json_str)
        return data

    def save(self,data,path):
        with open(path,'w',encoding='utf-8') as fp:
            json.dump(data,fp,ensure_ascii=False)

    def crawl_last_day_corona_virous(self):
        home_page=self.get_content_from_url(self.url)
        last_data = self.parse_home_page(home_page)

        self.save(last_data,'data/last_day.json')

    def crawl_corona_virous(self):
        with open('data/last_day.json',encoding='utf-8') as fp:
            last_day_data = json.load(fp)
        corona=[]
        for country in tqdm(last_day_data,'1.23以来疫情数据'):
            data_url = country['statisticsData'];
            json_str=self.get_content_from_url(data_url)
            data = json.loads(json_str)['data']
            for one_day in data:
                one_day['provinceName']=country['provinceName']
                one_day['countryShortCode']=country['countryShortCode']
            corona.extend(data)
        self.save_data_to_excal(corona)
        self.save(corona,'data/corona.json')
    def save_data_to_excal(self,data):
        excel = openpyxl.Workbook()
        sheet = excel.active
        sheet.append(["provinceName", "countryShortCode", "confirmedCount", "confirmedIncr", "highDangerCount", "midDangerCount", "suspectedCount"])
        for i, d in enumerate(data):
            print(d['provinceName'])
            sheet.append([i, d['provinceName'], d['countryShortCode'], d['confirmedIncr'], d['highDangerCount'], d['midDangerCount'], d['suspectedCount']])
        filename = 'data/data.xlsx'
        excel.save(filename)
    def run(self):
        #self.crawl_last_day_corona_virous()
        self.crawl_corona_virous()

if __name__ == '__main__':
    Spider=CoronaVirusSpider()
    Spider.run()


