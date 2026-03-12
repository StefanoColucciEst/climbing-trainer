import { Routes, Route } from 'react-router-dom'
import { AppShell } from '../components/layout/AppShell'
import { HomePage } from '../pages/HomePage'
import { StatisticsPage } from '../pages/StatisticsPage'
import { TrainingPage } from '../pages/TrainingPage'
import { ClimbingPage } from '../pages/ClimbingPage'
import { GripListPage } from '../pages/statistics/GripListPage'
import { GripCreatePage } from '../pages/statistics/GripCreatePage'
import { GripDetailPage } from '../pages/statistics/GripDetailPage'
import { ConditioningPage } from '../pages/statistics/ConditioningPage'
import { PageHeader } from '../components/layout/PageHeader'

function DrillDownLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="min-h-screen bg-bg max-w-lg mx-auto px-4">
      {children}
    </div>
  )
}

export function AppRouter() {
  return (
    <Routes>
      <Route element={<AppShell />}>
        <Route index element={<HomePage />} />
        <Route path="statistics" element={<StatisticsPage />} />
        <Route path="training" element={<TrainingPage />} />
        <Route path="climbing" element={<ClimbingPage />} />
      </Route>
      <Route path="statistics/grips" element={<DrillDownLayout><PageHeader title="Grips" /><GripListPage /></DrillDownLayout>} />
      <Route path="statistics/grips/new" element={<DrillDownLayout><PageHeader title="New Grip" /><GripCreatePage /></DrillDownLayout>} />
      <Route path="statistics/grips/:id" element={<DrillDownLayout><GripDetailPage /></DrillDownLayout>} />
      <Route path="statistics/conditioning" element={<DrillDownLayout><PageHeader title="Conditioning" /><ConditioningPage /></DrillDownLayout>} />
    </Routes>
  )
}
